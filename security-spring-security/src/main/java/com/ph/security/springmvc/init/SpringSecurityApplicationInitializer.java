package com.ph.security.springmvc.init;

import com.ph.security.springmvc.config.WebSecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @program: security-spring-security
 * @description: Spring Security环境初始化
 * @author: panhao
 * @date: 2021-06-16 22:28
 **/
public class SpringSecurityApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    public SpringSecurityApplicationInitializer() {
        // 用到spring就把这个屏蔽掉，没用就得加上
        // super(WebSecurityConfig.class);
    }
}
