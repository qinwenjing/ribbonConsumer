/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan("com.example")
@EnableDiscoveryClient  //让该应用注册为Eureka客户端应用，以获得服务发现能力
@SpringBootApplication
//@EnableCircuitBreaker   // 开启断路器功能
public class ConsumerApplication {
    @Bean
    //开启客户端的负载均衡
    @LoadBalanced
    RestTemplate testTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
