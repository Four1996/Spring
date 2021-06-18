package com.itpanhao.test;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.itpanhao.config.SpringConfiguration;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigBeanDefinitionParser;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.sql.DataSource;
/**
 * @author panhao
 * @date 2021年04月08日 4:57 下午
 */
public class DataSourceTest {
    @Test//测试Spring容器产生数据源对象(druid)
    public void test5() throws Exception {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource datasource =  app.getBean(DruidDataSource.class);
        Connection connection=datasource.getConnection();
        System.out.println(connection);
        connection.close();

    }
    @Test//测试Spring容器产生数据源对象(c3p0)
    public void test4() throws Exception {
//        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        DataSource datasource =  app.getBean(DataSource.class);
        Connection connection=datasource.getConnection();
        System.out.println(connection);
        connection.close();

    }
    @Test//测试手动创建druid数据源（加载properties文件形式）
    public void test3() throws SQLException {
        ResourceBundle rb=ResourceBundle.getBundle("jdbc");
        String driver=rb.getString("jdbc.driver");
        String url=rb.getString("jdbc.url");
        String username=rb.getString("jdbc.username");
        String password=rb.getString("jdbc.password");
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test//测试手动创建druid数据源
    public void test2() throws Exception{
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("00000000");
        Connection connection= dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test//测试手动创建c3p0数据源
    public void test1() throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("00000000");
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
