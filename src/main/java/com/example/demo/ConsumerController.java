/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.example.demo;

import javax.annotation.Resource;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ConsumerController {
    @Resource
    @LoadBalanced
    RestTemplate restTemplate;
  /*  @Autowired
    private HelloService helloService;
*/
    @RequestMapping(value="/consumer", method=RequestMethod.GET)
    public String helloConsumer(){
        log.info("/hello, consumer.....");
        return restTemplate.getForEntity("http://hello-service/springBootTest/hello", String.class).getBody();
        // return helloService.helloService();
    }
}
