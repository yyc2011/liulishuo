package com.demo.service.impl;

import com.demo.constant.CODE;
import com.demo.model.Relation;
import com.demo.model.User;
import com.demo.dao.RelationDao;
import com.demo.dao.UserDao;
import com.demo.service.UserService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yyc on 2017/7/14.
 */
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao ;

    @Resource
    private RelationDao relationDao;


    public Long createUser(User user) {
        Long result =userDao.insert(user);

        return result;
    }

    public int fromAtoB(Long fromUserId, Long toUserId, Long balance,int type) {
        if(balance<=0){
            return  CODE.ERR02.getType();
        }

        int result= CODE.SUEESS.getType();
        if(type==CODE.BORROW.getType()){
            result = borrow(fromUserId,toUserId,balance);
        }else if(type==CODE.PAYBACK.getType()){
            result =payBack(fromUserId,toUserId,balance);
        }
        return 0;
    }

    //借钱动作
    @Transactional(isolation= Isolation.SERIALIZABLE)
    private int borrow(Long fromUserId, Long toUserId, Long balance){


        User fromUser =userDao.queryById(fromUserId);
        User toUser =userDao.queryById(toUserId);

        if(fromUser==null || toUser==null){
            return CODE.USER_NOT_EXIST.getType();
        }

        if(fromUser.getBalance()-balance <0){//保证借钱出去后，剩下的余额>=0
            return CODE.EXCEED_BALANCE.getType();
        }

        Relation r = new Relation();
        r.setFromUserId(fromUserId);
        r.setToUserId(toUserId);
        r.setBalance(balance);
        Long id=relationDao.insert(r);

        User newFromUser = new User();
        newFromUser.setId(fromUser.getId());
        newFromUser.setBalance(fromUser.getBalance()-balance);

        User newToUser = new User();
        newToUser.setId(toUser.getId());
        newToUser.setBalance(toUser.getBalance()+balance);

        int n1 =userDao.update(newFromUser);               //余额减少后更新
        int n2 =userDao.update(newToUser);                 //余额增加后更新

        if(id>0 && n1==1 && n2==1){                        //插入成功 且两次更新各只影响一个用户记录
            return CODE.SUEESS.getType();
        }
        return CODE.ERR01.getType();
    }
    //还钱动作
    @Transactional(isolation= Isolation.SERIALIZABLE)
    private int payBack(Long fromUserId, Long toUserId, Long balance){

        User fromUser =userDao.queryById(fromUserId);
        User toUser =userDao.queryById(toUserId);

        if(fromUser==null || toUser==null){
            return CODE.USER_NOT_EXIST.getType();
        }

        if(fromUser.getBalance()-balance <0){ //判断还钱出去后，剩下的余额>=0
            return CODE.EXCEED_BALANCE.getType();
        }

        Long totolBorrow=relationDao.queryTotalAtoB(toUserId,fromUserId);
        Long totolPaybacked=relationDao.queryTotalAtoB(fromUserId,toUserId);

        if(balance>totolBorrow-totolPaybacked){//判断还款数是否超出当前欠款
            return CODE.EXCEED_BORROW_NUMBER.getType();
        }

        Relation r = new Relation();
        r.setFromUserId(fromUserId);
        r.setToUserId(toUserId);
        r.setBalance(balance);
        Long id = relationDao.insert(r); //记录新的转账信息

        User newFromUser =  new User();
        newFromUser.setId(fromUserId);
        newFromUser.setBalance(fromUser.getBalance()-balance);

        User newToUser =  new User();
        newToUser.setId(toUserId);
        newToUser.setBalance(toUser.getBalance()+balance);


        int n1=userDao.update(newFromUser);     //更新还款人余额
        int n2= userDao.update(newToUser);      //更新收款人余额

        if(id>0 && n1==1 && n2 ==1){            //插入成功 且两次更新各只影响一个用户记录
            return CODE.SUEESS.getType();
        }else{
            return CODE.ERR01.getType();
        }
    }

}
