/*
 * @(#)Config3344App.java 2019/12/28
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author lilu
 * @date 2019/12/28
 * @since 1.0.0
 */
@SpringBootApplication
// 开启config服务端
@EnableConfigServer
public class Config3344App {

	public static void main(String[] args) {
		SpringApplication.run(Config3344App.class, args);
	}

}
