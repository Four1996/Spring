package com.ph.security.distributed.order.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * @program: distributed-security
 * @description:配置授权服务
 * @author: panhao
 * @date: 2021-06-20 20:01
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }
    // 配置客户端详细信息服务
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 这里客户端实际上是配置在数据库当中的，这里为了方便演示配置在内存当中
        clients.inMemory()//使用in-memory存储
                    .withClient("c1")//client_id
                .secret(new BCryptPasswordEncoder().encode("secret"))//客户端的秘钥
                .resourceIds("res1")//资源列表
                .authorizedGrantTypes("authorization_code",
                        "password","client_credentials","implicit","refresh_token")//该client允许的授权类型
        // authorization_code,password,client_credentials,implicit,refresh_token
                .scopes("all")//允许的授权范围
                .autoApprove(false)//false 跳转到授权的页面
                // 加上验证回调地址
                .redirectUris("http://www.baidu.com");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
    }
}
