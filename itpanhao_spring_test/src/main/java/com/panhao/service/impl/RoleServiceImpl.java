package com.panhao.service.impl;

import com.panhao.dao.RoleDao;
import com.panhao.domain.Role;
import com.panhao.service.RoleService;

import java.util.List;

/**
 * @author panhao
 * @date 2021年05月26日 9:02 下午
 */
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
        List<Role> roleList=roleDao.findAll();
        return roleList;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
