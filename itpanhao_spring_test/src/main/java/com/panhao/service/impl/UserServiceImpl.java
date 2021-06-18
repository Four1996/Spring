package com.panhao.service.impl;

import com.panhao.dao.RoleDao;
import com.panhao.dao.UserDao;
import com.panhao.domain.Role;
import com.panhao.domain.User;
import com.panhao.service.UserService;

import java.util.List;

/**
 * @author panhao
 * @date 2021年05月26日 10:29 下午
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
//        封装userList中的每一个User的roles数据
        for (User user : userList) {
//            获得user的id
            Long id=user.getId();
//            将id作为参数，查询当前的userId对应的Role集合数据
            List<Role> roles=roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
//        第一步 向sys_user表中存储数据
        Long userId=userDao.save(user);
//        第二步 向sys_user_role表中存储多条数据
        userDao.saveUserRoleRel(userId,roleIds);
    }

    @Override
    public void del(Long userId) {
//       1、 删除sys_user_role关系表
        userDao.delUserRoleRel(userId);
//       2、 删除sys_user表
        userDao.del(userId);
    }
}
