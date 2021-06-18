package com.panhao.test;

import com.panhao.domain.User;
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
public class MyBatisTest {
    private UserMapper mapper;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }
    @Test
    public void testSave(){
        User user=new User();
        user.setUsername("ttt");
        user.setPassword("111");
        mapper.save(user);
    }
    @Test
    public void testUpdate(){
        User user=new User();
        user.setId(10);
        user.setUsername("lucy");
        user.setPassword("123");
        mapper.update(user);
    }
    @Test
    public void testDelete(){

        mapper.delete(10);
    }
    @Test
    public void testFindById(){
        User user=mapper.findById(5);
        System.out.println(user);
    }
    @Test
    public void testFindAll(){
        List<User> user=mapper.findAll();
        for (User user1 : user) {
            System.out.println(user1);
        }
    }


}
