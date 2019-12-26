/*
 * @(#)EurekaServer7001App.java 2019/12/21
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lilu
 * @date 2019/12/21
 * @since 1.0.0
 */
@SpringBootApplication
// 启用eureka服务,接收其他服务注册
@EnableEurekaServer
public class EurekaServer7003App {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003App.class, args);
    }

}
