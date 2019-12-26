/*
 * @(#)DeptConsumerController.java 2019/12/21
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud.controller;

import com.nuctech.springcloud.constant.CommonConstants;
import com.nuctech.springcloud.entities.Dept;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author lilu
 * @date 2019/12/21
 * @since 1.0.0
 */
@RestController
@RequestMapping("/consumer/dept")
@AllArgsConstructor
public class DeptConsumerController {
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    /**
     * 使用注册在EurekaServer中的微服务名称
     * 优点：Ribbon和Eureka整合后Consumer可以直接调用服务名而不用再关心地址和端口号
     */
    private static final String REST_URL_PREFIX = "http://" + CommonConstants.MicroServiceName.DEPT;
    /**
     * 使用restTemplate访问restful接口非常的简单粗暴无脑。
     * (url, requestMap, ResponseBean.class)这三个参数分别代表
     * REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */
    private final RestTemplate restTemplate;

    @RequestMapping(value = "/add")
    public boolean add(Dept dept) {
        return this.restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Long deptNo) {
        return this.restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + deptNo, Dept.class);
    }

    @RequestMapping(value = "/list")
    public List<Dept> list() {
        return this.restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    @RequestMapping(value = "/discovery")
    public Object discovery() {
        return this.restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }
}
