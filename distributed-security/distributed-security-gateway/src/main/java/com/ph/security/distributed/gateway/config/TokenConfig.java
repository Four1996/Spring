package com.ph.security.distributed.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @program: distributed-security
 * @description: token配置
 * @author: panhao
 * @date: 2021-06-23 21:48
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
}
