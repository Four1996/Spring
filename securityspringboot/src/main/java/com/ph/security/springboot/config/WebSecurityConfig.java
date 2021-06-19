package com.ph.security.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @program: security-spring-security
 * @description: SpringSecurityConfig
 * @author: panhao
 * @date: 2021-06-16 21:27
 **/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
     // 定义用户信息服务（查询用户信息）
    // @Bean
    // public UserDetailsService userDetailsService(){
    //     InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
    //     manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
    //     manager.createUser(User.withUsername("lisi").password("123").authorities("p2").build());
    //     return manager;
    // }

    // 密码编码器
    // @Bean
    // public PasswordEncoder passwordEncoder(){
    //     return NoOpPasswordEncoder.getInstance();
    // }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    // 安全拦截机制(最重要)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//屏蔽CSRF控制，即spring security不再限制CSRF
                .authorizeRequests()

                .antMatchers("/r/r1").hasAuthority("p1")
                .antMatchers("/r/r2").hasAuthority("p2")
                .antMatchers("/r/**").authenticated()//所有/r/**的请求必须认证通过
                .anyRequest().permitAll()//除了/r/**，其他的请求可以访问
                .and()
                .formLogin()//允许表单登录
                .loginPage("/login-view")//登录页面
                .loginProcessingUrl("/login")
                .successForwardUrl("/login-success")//自定义登录成功给的页面地址
        .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login-view?logout");


    }
}
