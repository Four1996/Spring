package com.panhao.dao;

import com.panhao.domain.User;

import java.util.List;

/**
 * @author panhao
 * @date 2021年05月26日 10:33 下午
 */
public interface UserDao {
    List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long id, Long[] roleIds);

    void delUserRoleRel(Long userId);

    void del(Long userId);

}
