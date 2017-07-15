package com.demo.dao.impl;

import com.demo.model.User;
import com.demo.dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yyc on 2017/7/13.
 */
public class UserDaoImpl implements UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public Long insert(User user) {

        int id =jdbcTemplate.update("insert into user (name,balance) values(?,?)",new Object[]{user.getName(),user.getBalance()},new int []{Types.VARCHAR,Types.BIGINT});

        return Long.valueOf(id);
    }

    public User queryById(Long id) {

        List<Map<String, Object>> list=jdbcTemplate.queryForList("select * from user where id = "+id.toString());

        if(list==null ||list.size()==0){
            return null;
        }
        User u = convert(list.get(0));

        return u;
    }




    public Integer update(User user) {
        if(user==null ||user.getId()==null){
            return null;
        }

        int id =jdbcTemplate.update("update user set balance = ? where id=?  ",new Object[]{user.getName(),user.getBalance()},new int []{Types.VARCHAR,Types.BIGINT});

        return id;
    }



    private User convert(Map<String, Object> map){
        if(map==null){
            return null;
        }

        User u = new User();
        if(map.get("id")!=null){
            u.setId((Long)map.get("id"));
        }
        if(map.get("name")!=null){
            u.setName(map.get("name").toString());
        }
        if(map.get("amount")!=null){
            u.setBalance((Long)map.get("amount"));
        }
        return u;
    }

}
