package com.itpanhao.service.impl;

import com.itpanhao.dao.AccountDao;
import com.itpanhao.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author panhao
 * @date 2021年05月21日 7:27 下午
 */
@Service("accountService")
//@Transactional(isolation = Isolation.READ_COMMITTED)
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao){
        this.accountDao=accountDao;
    }
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        int i=1/0;
        accountDao.in(inMan,money);
    }
//    @Transactional(isolation = Isolation.DEFAULT)
//    public void xxx(){}
}
