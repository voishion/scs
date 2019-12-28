/*
 * @(#)ConfigClientController.java 2019/12/28
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证是否能从GitHub上读取配置
 *
 * @author lilu
 * @date 2019/12/28
 * @since 1.0.0
 */
@RestController
public class ConfigClientController {
	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServers;

	@Value("${server.port}")
	private String port;

	@RequestMapping("/config")
	public String getConfig() {
		String str = "applicationName: " + applicationName + "\t eurekaServers:" + eurekaServers + "\t port: " + port;
		System.out.println("******str: " + str);
		return "applicationName: " + applicationName + "\t eurekaServers:" + eurekaServers + "\t port: " + port;
	}
}
