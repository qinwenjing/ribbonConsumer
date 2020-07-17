/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.example.demo;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuyanjiang create at 2019-06-21
 */
// @Configuration
public class RestTemplateConfig {

   /* @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(20000); // 单位为ms
        factory.setConnectTimeout(5000); // 单位为ms

        RestTemplate restTemplate = new RestTemplate(factory);

        // 设置转换器
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        converters.add(new MappingJackson2HttpMessageConverter());

        restTemplate.setMessageConverters(converters);
        return restTemplate;
    }*/

}
