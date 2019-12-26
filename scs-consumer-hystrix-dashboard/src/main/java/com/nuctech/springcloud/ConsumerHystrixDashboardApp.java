/*
 * @(#)ConsumerHystrixDashboardApp.java 2019/12/22
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author lilu
 * @date 2019/12/22
 * @since 1.0.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboardApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashboardApp.class, args);
    }

}
