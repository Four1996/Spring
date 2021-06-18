package com.itpanhao.web;

import com.itpanhao.config.SpringConfiguration;
import com.itpanhao.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author panhao
 * @date 2021年04月08日 6:53 下午
 */
public class UserController {
    public static void main(String[] args) {
//        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();
//        app.close();

    }
}
