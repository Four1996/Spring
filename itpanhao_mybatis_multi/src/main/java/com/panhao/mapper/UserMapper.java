package com.panhao.mapper;

import com.panhao.domain.User;

import java.util.List;

/**
 * @author panhao
 * @date 2021年06月01日 2:29 下午
 */
public interface UserMapper {
    public List<User> findAll();
    public List<User> findUserAndRoleAll();
}
