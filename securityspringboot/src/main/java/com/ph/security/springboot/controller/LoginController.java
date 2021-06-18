package com.ph.security.springboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: securityspringmvc
 * @description: 用户登录界面
 * @author: panhao
 * @date: 2021-06-16 19:13
 **/
@RestController
public class LoginController {
    @RequestMapping(value = "/login-success",produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess(){
        return "登录成功";
    }
    @GetMapping(value = ("/r/r1"),produces = {"text/plain;charset=UTF-8"})
    public String r1(){
        return "访问资源r1";
    }
    @GetMapping(value = ("/r/r2"),produces = {"text/plain;charset=UTF-8"})
    public String r2(){
        return "访问资源r2";
    }
}
