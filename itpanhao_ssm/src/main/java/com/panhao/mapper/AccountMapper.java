package com.panhao.mapper;

import com.panhao.domain.Account;

import java.util.List;

/**
 * @author panhao
 * @date 2021年06月02日 6:31 下午
 */
public interface AccountMapper {
    public void save(Account account);
    public List<Account> findAll();
}
