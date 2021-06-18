package com.panhao.mapper;

import com.panhao.domain.Order;

import java.util.List;

/**
 * @author panhao
 * @date 2021年06月01日 2:58 下午
 */
public interface OrderMapper {
    public List<Order> findAll();
}
