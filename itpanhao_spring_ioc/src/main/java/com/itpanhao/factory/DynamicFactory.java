package com.itpanhao.factory;

import com.itpanhao.dao.UserDao;
import com.itpanhao.dao.impl.UserDaoImpl;

/**
 * @author panhao
 * @date 2021年04月08日 3:56 下午
 */
public class DynamicFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
