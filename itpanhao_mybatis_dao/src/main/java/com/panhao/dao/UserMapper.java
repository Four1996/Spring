package com.panhao.dao;

import com.panhao.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @author panhao
 * @date 2021年05月29日 7:24 下午
 */
public interface UserMapper {
    public List<User> findAll() throws IOException;
    public User findById(int id);
}
