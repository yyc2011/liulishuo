package com.demo.model;

/**
 * Created by yyc on 2017/7/14.
 */
public class RelationParam {
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
     * 版本号
     */
    private String version;

    public RelationParam() {
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


}
