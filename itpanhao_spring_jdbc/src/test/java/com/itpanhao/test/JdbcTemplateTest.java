package com.itpanhao.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

/**
 * @author panhao
 * @date 2021年05月21日 10:42 上午
 */
public class JdbcTemplateTest {
    @Test
    public void test1() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("00000000");
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
//        设置数据源对象，让模板知道数据库在哪
        jdbcTemplate.setDataSource(dataSource);
//        执行操作
        int row = jdbcTemplate.update("insert into account values (?,?)", "tom", 5000);
        System.out.println(row);


    }
    @Test
    public void test2() throws PropertyVetoException{
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        int row=jdbcTemplate.update("insert into account values(?,?)","lucy",5000);

        System.out.println(row);
    }


}