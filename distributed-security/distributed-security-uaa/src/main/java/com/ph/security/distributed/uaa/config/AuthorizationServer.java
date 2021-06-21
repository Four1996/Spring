package com.ph.security.distributed.uaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @program: distributed-security
 * @description:配置授权服务
 * @author: panhao
 * @date: 2021-06-20 20:01
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private ClientDetailsService clientDetailsService;
    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;
    @Autowired
    private AuthenticationManager authenticationManager;

    // 配置客户端详细信息服务
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 这里客户端实际上是配置在数据库当中的，这里为了方便演示配置在内存当中
        clients.inMemory()//使用in-memory存储
                .withClient("c1")//client_id
                .secret(new BCryptPasswordEncoder().encode("secret"))//客户端的秘钥
                .resourceIds("res1")//资源列表
                .authorizedGrantTypes("authorization_code",
                        "password", "client_credentials", "implicit", "refresh_token")//该client允许的授权类型
                // authorization_code,password,client_credentials,implicit,refresh_token
                .scopes("all")//允许的授权范围
                .autoApprove(false)//false 跳转到授权的页面
                // 加上验证回调地址
                .redirectUris("http://www.baidu.com");
    }

    // 令牌管理服务
    @Bean
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices services = new DefaultTokenServices();
        //客户端信息服务
        services.setClientDetailsService(clientDetailsService);
        //是否刷新令牌
        services.setSupportRefreshToken(true);
        //令牌的存储策略
        services.setTokenStore(tokenStore);
        //令牌默认有效期2小时
        services.setAccessTokenValiditySeconds(7200);
        // 刷新令牌默认有效期3天
        services.setRefreshTokenValiditySeconds(259200);
        return services;
    }

    // 令牌访问端点
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .authenticationManager(authenticationManager)//密码模式需要
                .authorizationCodeServices(authorizationCodeServices)//授权模式需要
                // 令牌管理服务
                .tokenServices(tokenServices())
                //允许post提交访问令牌
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }

    @Bean
    public AuthorizationCodeServices authorizationCodeServices() { //设置授权码模式的授权码如何 存取，暂时采用内存方式
        return new InMemoryAuthorizationCodeServices();
    }
    // 令牌访问端点的安全策略
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
                //提公有秘钥的端点，如果你使用JWT令牌的话
                .tokenKeyAccess("permitAll()")
                //检测令牌用于资源服务访问的令牌解析端点
                .checkTokenAccess("permitAll()")
                //允许表单认证，申请令牌
                .allowFormAuthenticationForClients();
    }

}
