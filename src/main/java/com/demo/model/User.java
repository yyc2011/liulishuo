package com.demo.model;

import java.io.Serializable;

/**
 * Created by yyc on 2017/7/13.
 */
public class User implements Serializable{

    /**
     *  用户ID
     */
    private Long id ;

    /**
     *  用户姓名
     */
    private String name;

    /**
     * 用户余额 单位：分
     */
    private Long balance;


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
