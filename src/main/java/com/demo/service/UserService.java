package com.demo.service;

import com.demo.model.User;

/**
 * Created by yyc on 2017/7/13.
 */
public interface UserService {

    /**
     * @param user 待创建的用户
     * @return     用户ID
     */
    public Long createUser(User user);
    /**
     * 借钱、还钱接口
     * @param fromUserId 资金来源方
     * @param toUserId 资金流向方
     * @param balance 资金数额 必须>0 必须整数 单位 分
     * @param type 2001(com.demo.constant.CODE.BORROW.getType()):该次资金流动属于借钱动作
     *             2002(com.demo.constant.CODE.PAYBACK.getType()):该次资金流动属于还钱动作
     */
    public int fromAtoB(Long fromUserId,Long toUserId,Long balance,int type);
}
