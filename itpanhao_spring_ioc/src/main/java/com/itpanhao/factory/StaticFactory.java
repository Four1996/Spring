package com.itpanhao.factory;

import com.itpanhao.dao.UserDao;
import com.itpanhao.dao.impl.UserDaoImpl;

/**
 * @author panhao
 * @date 2021年04月08日 3:53 下午
 */
public class StaticFactory {
    public static UserDao geyUserDao(){
        return new UserDaoImpl();
    }
}
