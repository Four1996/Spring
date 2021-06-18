package com.panhao.dao.impl;

import com.panhao.dao.UserMapper;
import com.panhao.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author panhao
 * @date 2021年05月29日 7:25 下午
 */
//public class UserMapperImpl implements UserMapper {
//    @Override
//    public List<User> findAll() throws IOException {
//        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        List<User> userList = sqlSession.selectList("userMapper.findAll");
//        return userList;
//    }
//}
