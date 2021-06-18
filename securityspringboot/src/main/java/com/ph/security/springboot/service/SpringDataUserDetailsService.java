package com.ph.security.springboot.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @program: securityspringboot
 * @description:
 * @author: panhao
 * @date: 2021-06-17 20:15
 **/
@Service
public class SpringDataUserDetailsService implements UserDetailsService {
    //根据账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //将来连接数据库根据账号查询用户信息
        //暂时采用模拟方式
        //登录账号
        System.out.println("username="+username);
        //暂时采用模拟方式
        UserDetails userDetails = User.withUsername("zhangsan").password("$2a$10$DlwP39gp.XgPVH81M7ZpNeAYbkkONDtO275NumX2zKj.iWCaxeW1.").authorities("p1").build();

        return userDetails;
    }
}
