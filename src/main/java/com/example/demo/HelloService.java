/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

// @Service
public class HelloService {
   /* private static Logger logger = LoggerFactory.getLogger(HelloService.class);
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback", commandKey = "helloKey")
    public String helloService() {
        long time1 = System.currentTimeMillis();
        String result = restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
        logger.info("Spend time :" + (System.currentTimeMillis() - time1));
        return result;
    }

    public String helloFallback() {
        return "error";
    }*/
}
