package com.panhao.dao.impl;

import com.panhao.dao.RoleDao;
import com.panhao.domain.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author panhao
 * @date 2021年05月26日 9:05 下午
 */
public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));

        return roleList;
    }

    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role value(?,?,?)",null,role.getRoleName(),role.getRoleDesc());
    }
//返回所有的角色信息
    @Override
    public List<Role> findRoleByUserId(Long id) {
        List<Role> roles = jdbcTemplate.query("select * from sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId=?", new BeanPropertyRowMapper<Role>(Role.class), id);
        return roles;
    }
}
