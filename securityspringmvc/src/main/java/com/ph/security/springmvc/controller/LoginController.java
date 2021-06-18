package com.ph.security.springmvc.controller;

import com.ph.security.springmvc.model.AuthenticationRequest;
import com.ph.security.springmvc.model.UserDto;
import com.ph.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @program: securityspringmvc
 * @description: 用户登录界面
 * @author: panhao
 * @date: 2021-06-16 19:13
 **/
@RestController
public class LoginController {
    @Autowired
    AuthenticationService authenticationService;
    @RequestMapping(value = "/login",produces = "text/plain;charset=UTF-8")
    public String login(AuthenticationRequest authenticationRequest, HttpSession session){
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        // 存入到session
        session.setAttribute(UserDto.SESSION_USER_KEY,userDto);
        return userDto.getUsername()+"登录成功";
    }
    @GetMapping(value = "/logout",produces = {"text/plain;charset=UTF-8"})
    public String logout(HttpSession session){
        session.invalidate();
        return "退出成功";
    }
    @GetMapping(value = "/r/r1",produces = {"text/plain;charset=UTF-8"})
    public String r1(HttpSession session){
        String fullname=null;
        Object object = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (object==null){
            fullname="匿名";
        }else{
            UserDto userDto= (UserDto) object;
            fullname=userDto.getFullname();
        }
        return fullname+"访问资源r1";
    }
    @GetMapping(value = "/r/r2",produces = {"text/plain;charset=UTF-8"})
    public String r2(HttpSession session){
        String fullname=null;
        Object object = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (object==null){
            fullname="匿名";
        }else{
            UserDto userDto= (UserDto) object;
            fullname=userDto.getFullname();
        }
        return fullname+"访问资源r2";
    }
}
