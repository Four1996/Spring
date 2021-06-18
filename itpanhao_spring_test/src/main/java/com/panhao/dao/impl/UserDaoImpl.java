package com.panhao.dao.impl;

import com.panhao.dao.UserDao;
import com.panhao.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author panhao
 * @date 2021年05月26日 10:33 下午
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));

        return userList;
    }

    @Override
    public Long save(User user) {
//        jdbcTemplate.update("insert into sys_user values(?,?,?,?,?)",null,user.getUsername(),user.getEmail(),user.getPassword(),user.getPhoneNum());
//       返回当前保存的用户的id，该id是数据库自动生成的。
//        创建PreparedStatementCreator
        PreparedStatementCreator creator=new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//                使用原始的jdbc完成有个PreparedStatement的组建
                PreparedStatement preparedStatement = con.prepareStatement("insert into sys_user values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setObject(2,user.getUsername());
                preparedStatement.setObject(3,user.getEmail());
                preparedStatement.setObject(4,user.getPassword());
                preparedStatement.setObject(5,user.getPhoneNum());

                return preparedStatement;
            }
        };
//        创建keyHolder
        GeneratedKeyHolder keyHolder =new GeneratedKeyHolder();
        jdbcTemplate.update(creator,keyHolder);
//        获得生成的主键
        long userId = keyHolder.getKey().longValue();

        return userId;
    }

    @Override
    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values (?,?)",userId,roleId);
        }
    }

    @Override
    public void delUserRoleRel(Long userId) {
        jdbcTemplate.update("delete from sys_user_role sur where sur.userId=?",userId);

    }

    @Override
    public void del(Long userId) {
        jdbcTemplate.update("delete from sys_user  where id=?",userId);
    }
}
