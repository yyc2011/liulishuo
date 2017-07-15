package com.demo.web.controller;

import com.demo.constant.CODE;
import com.demo.model.User;
import com.demo.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import  java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
 * Created by yyc on 2017/7/12.
 */

@Controller
public class UserController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private UserService userService;


    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    @ResponseBody
    public String create(@RequestParam("name") String name,@RequestParam("balance") Long balance){

        User u = new User();

        u.setName(name);
        if(balance!=null) {
            u.setBalance(balance);
        }else{
            u.setBalance(0L);
        }
        Long id=userService.createUser(u);

        if(id!=null){
            return id.toString();
        }
        return "创建用户失败";
    }


    @RequestMapping(value = "/user/borrow", method = RequestMethod.GET)
    @ResponseBody
    public String borrow(@RequestParam("toUserId") Long toUserId,@RequestParam("fromUserId") Long fromUserId,@RequestParam("balance") Long balance){
        int code=userService.fromAtoB(fromUserId,toUserId,balance, CODE.BORROW.getType());
        return String.valueOf(code);
    }

    @RequestMapping(value = "/user/payback", method = RequestMethod.GET)
    @ResponseBody
    public String payback(@RequestParam("toUserId") Long toUserId,@RequestParam("fromUserId") Long fromUserId,@RequestParam("balance") Long balance){


        int code=userService.fromAtoB(fromUserId,toUserId,balance, CODE.BORROW.getType());
        return String.valueOf(code);
    }
}
