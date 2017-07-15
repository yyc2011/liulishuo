package com.demo.constant;

/**
 * Created by yyc on 2017/7/15.
 */
public enum CODE {
    ERR01(0001,"数据库写失败"),
    ERR02(0002,"金额必须>0"),

    SUEESS(1000,"转账成功"),
    EXCEED_BALANCE(1001,"转出超出余额"),
    EXCEED_BORROW_NUMBER(1002,"还款超出欠款数量"),

    BORROW(2001,"借钱"),
    PAYBACK(2002,"还钱"),

    USER_NOT_EXIST(3001,"用户不存在");


    private int type;

    private String description;

    private CODE(int type, String description){
        this.type = type;
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
