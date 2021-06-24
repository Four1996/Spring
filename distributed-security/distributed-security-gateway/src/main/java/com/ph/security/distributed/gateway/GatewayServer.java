package com.ph.security.distributed.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @program: distributed-security
 * @description: 启动类
 * @author: panhao
 * @date: 2021-06-23 21:45
 **/
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class GatewayServer {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServer.class,args);
    }
}
