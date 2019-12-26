/*
 * @(#)ConsumerDept80App.java 2019/12/21
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud;

import com.nuctech.rule.MySelfRule;
import com.nuctech.springcloud.constant.CommonConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author lilu
 * @date 2019/12/21
 * @since 1.0.0
 */
@SpringBootApplication
// 开启Eureka客户端功能
@EnableEurekaClient
// 在启动该微服务的时候就能去加载我们的自定义Ribbon配置类
// @RibbonClient(name = CommonConstants.MicroServiceName.DEPT, configuration = MySelfRule.class)
// 多个微服务的负载均衡规则
@RibbonClients(value = {
        @RibbonClient(name = CommonConstants.MicroServiceName.DEPT, configuration = MySelfRule.class)
})
public class ConsumerDept80App {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDept80App.class, args);
    }

}
