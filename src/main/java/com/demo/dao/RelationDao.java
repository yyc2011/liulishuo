package com.demo.dao;

import com.demo.model.Relation;

import java.util.List;

/**
 * Created by yyc on 2017/7/13.
 */
public interface RelationDao {

    /**
     * 单条记录插入
     */
    public Long insert(Relation relation);

    public List<Relation> queryById(Long id);

    public Long queryTotalAtoB(Long AUserId, Long BUserId);

}
