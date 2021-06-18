package com.panhao.service;

import com.panhao.dao.UserMapper;
//import com.panhao.dao.impl.UserMapperImpl;
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
 * @date 2021年05月29日 7:30 下午
 */
public class ServiceDemo {
    public static void main(String[] args) throws IOException {
//        创建dao层对象
//        UserMapper userMapper=new UserMapperImpl();
//        List<User> all=userMapper.findALl();
//        System.out.println(all);
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.findAll();
        System.out.println(all);
        User user = mapper.findById(1);
        System.out.println(user);
    }
}
