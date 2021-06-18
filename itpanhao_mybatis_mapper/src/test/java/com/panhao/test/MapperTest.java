package com.panhao.test;

import com.panhao.domain.User;
import com.panhao.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @author panhao
 * @date 2021年05月29日 9:57 下午
 */
public class MapperTest {
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        模拟条件user
        User condition=new User();
        condition.setId(1);
//        condition.setUsername("zhangsan");
//        condition.setPassword("123");
        List<User> user = mapper.findByCondition(condition);
        System.out.println(user);
//        模拟ids的数据
        List<Integer> list=new LinkedList<>();
        list.add(1);
//        list.add(2);
//        list.add(3);
        List<User> userList = mapper.findByIds(list);
        System.out.println(userList);
    }
}
