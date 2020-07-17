/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;

@Configuration
public class MyRibbonConfiguration {
   // @Bean
    public IPing ribbonPing(IClientConfig config) {
        return new PingUrl();
    }
}
