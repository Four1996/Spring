package com.itpanhao.test;

import com.itpanhao.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.beans.PropertyVetoException;
import java.util.List;

/**
 * @author panhao
 * @date 2021年05月21日 10:42 上午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void testUpdate(){
        jdbcTemplate.update("update account set money=? where name=?",10000,"tom");
    }
    @Test
    public void testDelete(){
        jdbcTemplate.update("delete from account where name=?","tom");
    }
    @Test
    public void testQueryAll(){
        List<Account> accountList = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }
    @Test
    public void testQueryOne(){
        Account zhangsan = jdbcTemplate.queryForObject("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), "zhangsan");
        System.out.println(zhangsan);
    }
    @Test
    public void testQueryCOunt(){
        Integer count = jdbcTemplate.queryForObject("select count(*) from account", Integer.class);
        System.out.println(count);
    }

}