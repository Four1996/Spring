package com.ph.security.distributed.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: distributed-security
 * @description: springboot启动类
 * @author: panhao
 * @date: 2021-06-20 19:53
 **/
@SpringBootApplication
@EnableDiscoveryClient
// @EnableHystrix
// @EnableFeignClients(basePackages = {"com.ph.security.distributed.uaa"})
public class OrderServer {
    public static void main(String[] args) {
        SpringApplication.run(OrderServer.class,args);
    }
}
