/*
 * @(#)ConsumerDept80App.java 2019/12/21
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud;

import com.nuctech.springcloud.constant.CommonConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lilu
 * @date 2019/12/21
 * @since 1.0.0
 */
@SpringBootApplication
// 开启Eureka客户端功能
@EnableEurekaClient
// 在启动该微服务式是能去加载我们定义的Feign配置类
@EnableFeignClients(basePackages = CommonConstants.System.BASE_PACKAGES)
public class ConsumerDeptFeignApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDeptFeignApp.class, args);
    }

}
