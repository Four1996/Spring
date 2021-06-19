package com.ph.security.springboot.dao;

import com.ph.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
