package com.demo.model;

import java.io.Serializable;

/**
 * Created by yyc on 2017/7/13.
 */
public class Relation implements Serializable {
    /**
     * 关系ID
     */
    private Long id;

    /**
     * 来源方用户ID
     */
    private Long fromUserId;

    /**
     * 流向方用户ID
     */
    private Long toUserId;

    /**
     * 金额 分
     */
    private Long balance;

    public Relation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
