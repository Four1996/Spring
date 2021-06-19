package com.ph.security.springboot.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        return getUsername()+"登录成功";
    }
    @GetMapping(value = ("/r/r1"),produces = {"text/plain;charset=UTF-8"})
    @PreAuthorize("hasAuthority('p1')")//拥有p1权限的才能访问资源r1
    public String r1(){
        return getUsername()+"访问资源r1";
    }
    @GetMapping(value = ("/r/r2"),produces = {"text/plain;charset=UTF-8"})
    @PreAuthorize("hasAuthority('p2')")//拥有p2权限的才能访问资源r2
    public String r2(){
        return getUsername()+"访问资源r2";
    }
    // 获取当前用户信息
    private String getUsername(){
        String username=null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 用户身份
        Object principal = authentication.getPrincipal();
        if (principal==null){
            username="匿名";
        }
        if (principal instanceof UserDetails){
            UserDetails userDetails= (UserDetails) principal;
            username=userDetails.getUsername();
        }else{
            username=principal.toString();
        }
        return username;
    }
}
