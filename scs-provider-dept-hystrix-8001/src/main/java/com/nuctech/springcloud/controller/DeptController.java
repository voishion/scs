/*
 * @(#)DeptController.java 2019/12/21
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    // 一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrixGet")
    public Dept get(@PathVariable("deptNo") Long deptNo) {
        Dept dept = this.deptService.get(deptNo);
        if (dept == null) {
            throw new RuntimeException(String.format("没有编号为%d的部门信息", deptNo));
        }
        return dept;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return this.deptService.list();
    }

    /**
     * 服务熔断
     * 一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
     *
     * @author lilu
     * @date 2019/12/22 18:35
     * @since 1.0.0
     *
     * @param deptNo
     * @return com.nuctech.springcloud.entities.Dept
     */
    public Dept processHystrixGet(@PathVariable("deptNo") Long deptNo) {
        return new Dept()
                .setDeptNo(deptNo)
                .setDeptName(String.format("没有编号为%d的部门信息,@HystrixCommand", deptNo))
                .setDbSource("No this database in MySql");
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
