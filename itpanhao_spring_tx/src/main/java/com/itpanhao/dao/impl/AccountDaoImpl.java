package com.itpanhao.dao.impl;

import com.itpanhao.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author panhao
 * @date 2021年05月21日 7:19 下午
 */
public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public void out(String outMan,double money) {
        jdbcTemplate.update("update account set money=money-? where name=?",money,outMan);
    }

    @Override
    public void in(String inMan,double money) {
        jdbcTemplate.update("update account set money=money+? where name=?",money,inMan);
    }
}
