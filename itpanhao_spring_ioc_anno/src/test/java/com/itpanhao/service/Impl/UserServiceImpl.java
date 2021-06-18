package com.itpanhao.service.Impl;

import com.itpanhao.dao.UserDao;
import com.itpanhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author panhao
 * @date 2021年04月08日 6:51 下午
 */
//<bean id="userService" class="com.itpanhao.service.Impl.UserServiceImpl">
//<property name="userDao" ref="userDao"></property>
//</bean>
    @Service("userService")
//    @Scope("prototype")
public class UserServiceImpl implements UserService {
        @Value("${jdbc.driver}")
        private String driver;
//        @Autowired//按照数据类型从spring容器中进行匹配的。
//        @Qualifier("userDao")//是按照id名称从容器中进行匹配。但是要结合Autowired配合使用
    @Resource(name = "userDao")//相当于Autowired+Qualifier("userDao"),按照名称进行注入
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        userDao.save();
    }
    @PostConstruct
    public void init(){
        System.out.println("Service对象初始化。。。。");
    }
    @PreDestroy
    public void destory(){
        System.out.println("Service对象销毁。。。");
    }
}
