package com.panhao.mapper;

import com.panhao.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author panhao
 * @date 2021年06月01日 4:40 下午
 */
public interface UserMapper {
    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    public void save(User user);
    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    public void update(User user);
    @Delete("delete from user where id=#{id}")
    public void delete(int id);
    @Select("select * from user where id=#{id}")
    public User findById(int id);
    @Select("select * from user")
    public List<User> findAll();
    @Select("select * from user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    column = "id",
                    property = "orderList",
                    javaType = List.class,
                    many = @Many(select = "com.panhao.mapper.OrderMapper.findByUid")
            )
    })
    public List<User> findUserAndOrderAll();
    @Select("select * from user")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select ="com.panhao.mapper.RoleMapper.findByUid")
            )
    })
    public List<User> findUserAndRoleAll();
}
