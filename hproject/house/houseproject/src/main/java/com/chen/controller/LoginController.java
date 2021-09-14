package com.chen.controller;


import com.chen.pojo.AdminInfo;
import com.chen.pojo.Customer;
import com.chen.pojo.User;
import com.chen.service.ICustomerService;
import com.chen.service.IUserService;
import com.chen.util.JwtUtils2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController

public class LoginController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ICustomerService customerService;


    @RequestMapping("/login")
    public Object login(String username,String password,String type){
          AdminInfo info=new AdminInfo();
          Map maps=new HashMap<>();
          if(type.equals("1")){
              //管理员
              User user=userService.queryUserByNameAndPwd(username,password);
              if(user!=null){//存在
                  info.setId(user.getId());
                  info.setUsername(user.getUsername());
                  info.setType("1");
              }
          }else{
              //租客
              Customer customer=customerService.queryUserByNameAndPwd(username,password);
              if(customer!=null){
                  info.setId(customer.getId());
                  info.setUsername(customer.getCustname());
                  info.setType("0");
              }
          }
          //生成token
          String token= JwtUtils2.geneJsonWebToken(info);
          Map map=new HashMap<>();
          map.put("userId",info.getId());
          map.put("username",info.getUsername());
          map.put("type",info.getType());
          map.put("token",token);
          return map;
    }
}
