package com.ph.security.distributed.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @program: distributed-security
 * @description: 令牌配置
 * @author: panhao
 * @date: 2021-06-20 20:21
 **/
@Configuration
public class TokenConfig {
    // 令牌存储策略
    @Bean
    public TokenStore tokenStore(){
        // 内存方式，生成普通令牌
        return new InMemoryTokenStore();
    }
}
