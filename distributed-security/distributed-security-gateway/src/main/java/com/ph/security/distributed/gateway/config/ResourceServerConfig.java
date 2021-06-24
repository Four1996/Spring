package com.ph.security.distributed.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @program: distributed-security
 * @description:
 * @author: panhao
 * @date: 2021-06-21 16:59
 **/
@Configuration
public class ResourceServerConfig {
    public static final String RESOURCE_ID = "res1";



    //uaa资源服务配置
    @Configuration
    @EnableResourceServer
    public class UAAServerConfig extends ResourceServerConfigurerAdapter {
        @Autowired
        private TokenStore tokenStore;
        @Override
        public void configure(ResourceServerSecurityConfigurer resources){
            resources
                    // 验证令牌的服务
                    .tokenStore(tokenStore)
                    // 资源id
                    .resourceId(RESOURCE_ID)
                    .stateless(true);
        }
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/uaa/**")
                    //由于uaa是进行token端点验证的，所以可以允许进行访问，采用全部放行的方式。
                    .permitAll();

        }
    }


    //order资源
    @Configuration
    @EnableResourceServer
    public class OrderServerConfig extends ResourceServerConfigurerAdapter {
        @Autowired
        private TokenStore tokenStore;
        @Override
        public void configure(ResourceServerSecurityConfigurer resources){
            resources
                    // 验证令牌的服务
                    .tokenStore(tokenStore)
                    // 资源id
                    .resourceId(RESOURCE_ID)
                    .stateless(true);
        }
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/order/**")
                    .access("#oauth2.hasScope('ROLE_API')");

        }
    }

    // 配置其他的资源服务。。。




}
