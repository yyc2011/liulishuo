package com.demo.dao.impl;

import com.demo.model.Relation;
import com.demo.dao.RelationDao;
import com.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by yyc on 2017/7/13.
 */
public class RelationDaoImpl implements RelationDao {


    @Resource
    private JdbcTemplate jdbcTemplate;


    public Long insert(Relation relation) {
        return null;
    }

    public List<Relation> queryById(Long id) {
        return null;
    }

    public Long queryTotalAtoB(Long AUserId, Long BUserId){
        String sql_A_to_B ="select sum(balance) as total from relation where from_user_id = "+AUserId.toString()+
                " and to_user_id = "+BUserId.toString();

        List<Map<String, Object>> list_A_to_B=jdbcTemplate.queryForList(sql_A_to_B);

        Long total_A_to_B = 0L;
        if(list_A_to_B!=null && list_A_to_B.size()==1){
            total_A_to_B = convert(list_A_to_B.get(0));
        }

        return total_A_to_B ;
    }

    private Long convert(Map<String, Object> map){
        if(map==null){
            return null;
        }
        Long total = 0L;
        if(map.get("total")!=null){
            total = (Long)map.get("total");
        }
        return total;
    }

}
