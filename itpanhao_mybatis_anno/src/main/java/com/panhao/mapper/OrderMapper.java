package com.panhao.mapper;


import com.panhao.domain.Order;
import com.panhao.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @author panhao
 * @date 2021年06月01日 2:58 下午
 */
public interface OrderMapper {
    @Select("select * from orders where uid=#{uid}")
    public List<Order> findByUid(int uid);
    @Select("select * from orders")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(
//                    要封装的属性名称
                    column = "uid",
//                    代表根据哪个字段去查询user表的数据
                    property = "user",
//                    要封装的实体类型
                    javaType = User.class,
//                    select属性，代表查询那个接口的方法获得数据
                    one = @One(select="com.panhao.mapper.UserMapper.findById")
            )
    })
    public List<Order> findAll();
}
