package com.yunsoft.oauth.controller;

import com.yunsoft.oauth.service.CustomerUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.UUID;


@Controller
@RequestMapping("/api")
public class UserController {

    @RequestMapping("/userInfo")
    @ResponseBody
    public String getUser(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }
    @Autowired
    @Qualifier("customerUserDetailServiceImpl")
    private CustomerUserServiceImpl customerUserService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,Object> register(@RequestParam String username,@RequestParam String password){
        HashMap<String,Object> result = new HashMap<>();
        com.yunsoft.oauth.modle.User user =  com.yunsoft.oauth.modle.User.builder().userName(username).role("USER_ROLE").id(UUID.randomUUID().toString().replace("-","")).password(passwordEncoder.encode(password)).build();
        int r =  customerUserService.save(user);
        if(r == 1){
            result.put("code",200);
            result.put("result","插入成功");
            result.put("success",true);
        }else{
            result.put("code",200);
            result.put("result","插入失败");
            result.put("success",false);
        }
        return result;
    }
}
