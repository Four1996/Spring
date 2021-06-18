package com.itpanhao.test;

import com.itpanhao.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author panhao
 * @date 2021年04月08日 3:24 下午
 */
public class SpringTest {
    @Test//测试scope属性
    public  void test1(){
        ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) app.getBean("userDao");
//        UserDao userDao2= (UserDao) app.getBean("userDao");
        System.out.println(userDao);
//        app.close();
//        System.out.println(userDao2);
    }

}
