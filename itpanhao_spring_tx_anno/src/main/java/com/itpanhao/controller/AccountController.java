package com.itpanhao.controller;

import com.itpanhao.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author panhao
 * @date 2021年05月21日 7:32 下午
 */
public class AccountController {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = app.getBean(AccountService.class);
        accountService.transfer("tom","jack",500);
    }
}
