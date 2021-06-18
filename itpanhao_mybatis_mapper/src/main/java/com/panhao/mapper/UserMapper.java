package com.panhao.mapper;

import com.panhao.domain.User;

import java.util.List;

/**
 * @author panhao
 * @date 2021年05月29日 9:55 下午
 */
public interface UserMapper {
    public List<User> findByCondition(User user);
    public List<User> findByIds(List<Integer> ids);
}
