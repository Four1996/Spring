package com.panhao.service;

import com.panhao.domain.User;

import java.util.List;

/**
 * @author panhao
 * @date 2021年05月26日 10:28 下午
 */
public interface UserService {
    List<User> list();

    void save(User user, Long[] roleIds);

    void del(Long userId);
}
