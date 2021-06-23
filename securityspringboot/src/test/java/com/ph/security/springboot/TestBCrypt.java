package com.ph.security.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: securityspringboot
 * @description:
 * @author: panhao
 * @date: 2021-06-17 22:29
 **/
@RunWith(SpringRunner.class)
public class TestBCrypt {
    @Test
    public void testBCrypt(){
        // 对密码进行加密
        String hashpw = BCrypt.hashpw("secret", BCrypt.gensalt());
        System.out.println(hashpw);
    }
}
