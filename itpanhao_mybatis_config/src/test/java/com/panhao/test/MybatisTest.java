package com.panhao.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panhao.domain.User;
import com.panhao.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author panhao
 * @date 2021年05月31日 3:19 下午
 */
public class MybatisTest {
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        模拟user
        User user =new User();
        user.setUsername("ww");
        user.setPassword("123");
        user.setBirthday(new Date());
        mapper.save(user);
        sqlSession.close();
    }
    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user=mapper.findById(8);
        System.out.println(user.getBirthday());
        sqlSession.close();
    }
    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        设置分页相关参数 当前页+每页显示的条数
        PageHelper.startPage(2,3);
        List<User> userList=mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
//        获得与分页相关参数
        PageInfo<User> pageInfo=new PageInfo<>(userList);
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示条数："+pageInfo.getSize());
        System.out.println("总条数"+pageInfo.getTotal());
        System.out.println("总页数"+pageInfo.getPages());
        System.out.println("上一页："+pageInfo.getPrePage());
        System.out.println("下一页："+pageInfo.getNextPage());
        System.out.println("是否是第一页:"+pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页："+pageInfo.isIsLastPage());
        sqlSession.close();
    }

}
