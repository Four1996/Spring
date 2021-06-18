package com.itpanhao.service.impl;

import com.itpanhao.dao.UserDao;
import com.itpanhao.service.UserService;

/**
 * @author panhao
 * @date 2021年05月21日 9:31 下午
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
