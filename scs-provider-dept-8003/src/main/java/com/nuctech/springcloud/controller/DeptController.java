/*
 * @(#)DeptController.java 2019/12/21
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud.controller;

import com.nuctech.springcloud.constant.CommonConstants;
import com.nuctech.springcloud.entities.Dept;
import com.nuctech.springcloud.service.DeptService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lilu
 * @date 2019/12/21
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/dept")
@AllArgsConstructor
public class DeptController {
    private final DeptService deptService;
    private final DiscoveryClient discoveryClient; // 服务发现

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return this.deptService.add(dept);
    }

    @RequestMapping(value = "/get/{deptNo}", method = RequestMethod.GET)
    public Dept get(@PathVariable("deptNo") Long deptNo) {
        return this.deptService.get(deptNo);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return this.deptService.list();
    }

    /**
     * 增加自己服务描述的接口
     *
     * @author lilu
     * @date 2019/12/21 18:58
     * @since 1.0.0
     *
     * @param
     * @return java.lang.Object
     */
    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        log.info("总共有{}个微服务,以下是微服务列表:", list.size());
        if (list.isEmpty()) {
            log.info("[]", list.size());
        } else {
            log.info("{}", list);
        }

        // 查询当前服务
        String currentServerName = CommonConstants.MicroServiceName.DEPT;
        List<ServiceInstance> instances = discoveryClient.getInstances(currentServerName);
        if (!instances.isEmpty()) {
            log.info("打印{}服务信息:", currentServerName);
            instances.forEach(e -> log.info("ServiceId:{}, Host:{}, Port:{}, Uri:{}", e.getServiceId(), e.getHost(), e.getPort(), e.getUri()));
        }

        return this.discoveryClient;
    }
}
