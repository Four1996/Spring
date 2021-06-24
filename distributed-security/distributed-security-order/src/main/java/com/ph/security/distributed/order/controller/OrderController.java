package com.ph.security.distributed.order.controller;

import com.ph.security.distributed.order.model.UserDTO;
import org.apache.catalina.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: distributed-security
 * @description:
 * @author: panhao
 * @date: 2021-06-21 16:58
 **/
@RestController
public class OrderController {


    @GetMapping(value = "/r1")
    // 标记拥有p1权限才能访问资源
    @PreAuthorize("hasAnyAuthority('p1')")
    public String r1(){
        //获取用户身份信息
        UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userDTO.getUsername()+"访问资源1";
    }
}
