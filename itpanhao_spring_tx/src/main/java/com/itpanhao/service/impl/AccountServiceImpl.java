package com.itpanhao.service.impl;

import com.itpanhao.dao.AccountDao;
import com.itpanhao.service.AccountService;

/**
 * @author panhao
 * @date 2021年05月21日 7:27 下午
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao){
        this.accountDao=accountDao;
    }
    @Override
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        int i=1/0;
        accountDao.in(inMan,money);
    }
}
