package com.ph.security.distributed.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: distributed-security
 * @description: 启动类
 * @author: panhao
 * @date: 2021-06-23 20:56
 **/
@SpringBootApplication
@EnableEurekaClient
public class DiscoveryServer {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServer.class,args);
    }
}
