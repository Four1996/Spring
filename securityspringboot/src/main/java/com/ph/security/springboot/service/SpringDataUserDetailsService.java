package com.ph.security.springboot.service;

import com.ph.security.springboot.dao.UserDao;
import com.ph.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: securityspringboot
 * @description:
 * @author: panhao
 * @date: 2021-06-17 20:15
 **/
@Service
public class SpringDataUserDetailsService implements UserDetailsService {
    @Autowired
    UserDao userDao;

    //根据账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //将来连接数据库根据账号查询用户信息
        UserDto user = userDao.getUserByUsername(username);
        if (user ==null) {
            // 如果用户查不到，返回null，由provider去抛异常
            return null;
        }
        // 根据用户的id查询用户的权限
        List<String> permissionByUserId = userDao.findPermissionByUserId(user.getId());
        // 将permisssionByUserId转成数组
        String[] permissionArray=new String[permissionByUserId.size()];
        permissionByUserId.toArray(permissionArray);
        //登录账号
        UserDetails userDetails = User.withUsername(user.getUsername()).password(user.getPassword()).authorities(permissionArray).build();

        return userDetails;
    }

}
