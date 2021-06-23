package com.ph.security.distributed.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @program: distributed-security
 * @description: 令牌配置
 * @author: panhao
 * @date: 2021-06-20 20:21
 **/
@Configuration
public class TokenConfig {

    private String SIGNING_KEY="uaa123";

    @Bean
    public TokenStore tokenStore(){
        // Jwt令牌存储方案
        return new JwtTokenStore(accessTokenConverter());
    }
    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter converter=new JwtAccessTokenConverter();
        //对称秘钥，资源服务器使用该秘钥来验证。
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }
    // @Bean
    // public TokenStore tokenStore(){
    //     // 内存方式，生成普通令牌
    //     return new InMemoryTokenStore();
    // }
}
