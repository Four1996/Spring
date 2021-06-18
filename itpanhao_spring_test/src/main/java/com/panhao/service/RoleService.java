package com.panhao.service;

import com.panhao.domain.Role;

import java.util.List;

/**
 * @author panhao
 * @date 2021年05月26日 9:01 下午
 */
public interface RoleService {
    public List<Role> list();

    void save(Role role);
}
