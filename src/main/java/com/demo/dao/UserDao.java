package com.demo.dao;


import com.demo.model.User;

import java.util.List;

/**
 * Created by yyc on 2017/7/13.
 */
public interface UserDao {

    /**
     * 单条记录插入
     */
    public Long insert(User user);

    /**
     * 单条记录查询
     */
    public User queryById (Long id);
    /**
     * 单条记录更新
     */
    public Integer update (User user);

}
