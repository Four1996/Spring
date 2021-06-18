package com.itpanhao.demo;

import com.itpanhao.service.Impl.UserServiceImpl;
import com.itpanhao.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author panhao
 * @date 2021年04月08日 4:05 下午
 */
public class UserController {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext app=new FileSystemXmlApplicationContext("/Users/phfile/Desktop/JavaLearning/Spring/itpanhao_spring_ioc/src/main/resources/applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }
}
