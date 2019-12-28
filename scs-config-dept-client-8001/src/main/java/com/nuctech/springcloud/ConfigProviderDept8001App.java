/*
 * @(#)ProviderDept8001App.java 2019/12/21
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 主启动类
 *
 * @author lilu
 * @date 2019/12/21
 * @since 1.0.0
 */
@SpringBootApplication
// 本服务启动后会自动注册进eureka服务中
@EnableEurekaClient
// 开启本服务发现功能
@EnableDiscoveryClient
public class ConfigProviderDept8001App {

    public static void main(String[] args) {
        SpringApplication.run(ConfigProviderDept8001App.class, args);
    }

}
