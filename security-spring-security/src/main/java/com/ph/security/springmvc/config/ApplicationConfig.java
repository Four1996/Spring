package com.ph.security.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @program: security-spring-security
 * @description: applicationContext.xml
 * @author: panhao
 * @date: 2021-06-16 21:19
 **/
@Configuration//相当于applicationContext.xml文件
@ComponentScan(basePackages = "com.ph.security.springmvc"
        ,excludeFilters ={@ComponentScan.Filter(type= FilterType.ANNOTATION,value = Controller.class)} )
public class ApplicationConfig {
//   在此配置除了Controller的其他bean，比如：数据库连接池、事务管理器、业务bean等。

}
