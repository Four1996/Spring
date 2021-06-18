package com.itpanhao.test;

import com.itpanhao.config.SpringConfiguration;
import com.itpanhao.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * @author panhao
 * @date 2021年04月08日 7:46 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {
    @Autowired
    private UserService userService;
    @Autowired
    private DataSource dataSource;

    @Test
    public void test1() throws Exception{
        userService.save();
        System.out.println(dataSource.getConnection());
    }

}
