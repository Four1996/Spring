package com.panhao.test;

import com.panhao.domain.Order;
import com.panhao.domain.User;
import com.panhao.mapper.OrderMapper;
import com.panhao.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author panhao
 * @date 2021年06月01日 4:43 下午
 */
public class MyBatisTest3 {
    private UserMapper mapper;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }
    @Test
    public void testFindAll(){
        List<User> userList=mapper.findUserAndOrderAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
