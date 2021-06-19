package com.ph.security.springboot.dao;

import com.ph.security.springboot.model.PermissionDto;
import com.ph.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: securityspringboot
 * @description:
 * @author: panhao
 * @date: 2021-06-19 16:58
 **/
@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //根据账号查询用户信息
    public UserDto getUserByUsername(String username) {
        String sql = "select id,username,password,fullname,mobile from t_user where username=?";
        // 连接数据库查询用户
        List<UserDto> userDtoList = jdbcTemplate.query(sql,
                new Object[]{username},
                new BeanPropertyRowMapper<>(UserDto.class));
        if (userDtoList != null && userDtoList.size() == 1) {
            return userDtoList.get(0);
        }
        return null;
    }
    // 根据用户id查询用户权限
    public List<String> findPermissionByUserId(String userId){
        String sql="select * from t_permission where id in(" +
                "select permission_id from t_role_permission where role_id in(" +
                "select role_id from t_user_role where user_id=?" +
                ")" +
                ")";
        List<PermissionDto> permissionDtos = jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(PermissionDto.class));
        List<String> permissions=new ArrayList<>();
        for (PermissionDto permissionDto : permissionDtos) {
            permissions.add(permissionDto.getCode());
        }
        return permissions;
    }



}
