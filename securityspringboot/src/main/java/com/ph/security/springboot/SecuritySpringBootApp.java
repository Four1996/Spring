package com.ph.security.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @program: securityspringboot
 * @description: spring boot 启动类
 * @author: panhao
 * @date: 2021-06-17 16:09
 **/
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SecuritySpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SecuritySpringBootApp.class,args);
    }
}
