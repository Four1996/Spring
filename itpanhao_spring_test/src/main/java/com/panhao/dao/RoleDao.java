package com.panhao.dao;

import com.panhao.domain.Role;

import java.util.List;

/**
 * @author panhao
 * @date 2021年05月26日 9:04 下午
 */
public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(Long id);
}
