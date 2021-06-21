package com.ph.security.distributed.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @program: distributed-security
 * @description:
 * @author: panhao
 * @date: 2021-06-20 20:39
 **/
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)//开启基于方法的注解权限配置
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // 安全拦截机制(最重要)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//屏蔽CSRF控制，即spring security不再限制CSRF
                .authorizeRequests()
                // .antMatchers("/r/r1").hasAuthority("p1")
                // .antMatchers("/r/r2").hasAuthority("p2")
                .antMatchers("/r/**").authenticated()//所有/r/**的请求必须认证通过
                .anyRequest().permitAll()//除了/r/**，其他的请求可以访问
                .and()
                .formLogin();//允许表单登录
                // .loginPage("/login-view")//登录页面
                // .loginProcessingUrl("/login")
                // .successForwardUrl("/login-success")//自定义登录成功给的页面地址
                // .and()
                // .sessionManagement()
                // .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                // .and()
                // .logout()
                // .logoutUrl("/logout")
                // .logoutSuccessUrl("/login-view?logout");


    }
}
