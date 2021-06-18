package com.panhao.service;

import com.panhao.domain.Account;

import java.io.IOException;
import java.util.List;

/**
 * @author panhao
 * @date 2021年06月02日 6:32 下午
 */
public interface AccountService {
    public void save(Account account) throws IOException;
    public List<Account> findAll() throws IOException;
}
