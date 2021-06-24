package com.ph.security.distributed.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @program: distributed-security
 * @description:
 * @author: panhao
 * @date: 2021-06-21 16:59
 **/
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    public static final String RESOURCE_ID = "res1";

    @Autowired
    TokenStore tokenStore;


    @Override
    public void configure(ResourceServerSecurityConfigurer resources){

        resources
                // 资源id
                .resourceId(RESOURCE_ID)
                // 验证令牌的服务
                .tokenStore(tokenStore)
                .stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").access("#oauth2.hasScope('ROLE_ADMIN')")
                .and().csrf().disable()
                .sessionManagement()
                //stateless不创建session也不使用session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    // 资源服务令牌解析服务
    // @Bean
    // public ResourceServerTokenServices tokenService(){
    //     // 使用远程服务请求授权服务器校验token，必须制定校验token的url、client_id、client_secret
    //     RemoteTokenServices services=new RemoteTokenServices();
    //     services.setCheckTokenEndpointUrl("http://localhost:53020/uaa/oauth/check_token");
    //     services.setClientId("c1");
    //     services.setClientSecret("secret");
    //     return services;
    // }

}
