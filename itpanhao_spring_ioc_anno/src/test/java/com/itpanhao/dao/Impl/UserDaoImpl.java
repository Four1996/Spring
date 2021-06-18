package com.itpanhao.dao.Impl;

import com.itpanhao.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author panhao
 * @date 2021年04月08日 6:49 下午
 */
//<bean id="userDao" class="com.itpanhao.dao.Impl.UserDaoImpl"></bean>
    @Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save running...");
    }
}
