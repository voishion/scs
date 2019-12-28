/*
 * @(#)ZuulGatewayApp.java 2019/12/28
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author lilu
 * @date 2019/12/28
 * @since 1.0.0
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayApp {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApp.class, args);
	}

}
