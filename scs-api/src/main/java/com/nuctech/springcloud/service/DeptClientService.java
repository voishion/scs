/*
 * @(#)DeptClientService.java 2019/12/22
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud.service;

import com.nuctech.springcloud.constant.CommonConstants;
import com.nuctech.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Feign的面向接口编程的接口<br>
 * Feign通过接口的方法调用Rest服务（之前是Ribbon+RestTemplate），该请求发送给Eureka服务器（http://SCS-DEPT/dept/list）,通过Feign直接找到服务接口，由于在进行服务调用的时候融合了Ribbon技术，所以也支持负载均衡作用。
 *
 * @author lilu
 * @date 2019/12/22
 * @since 1.0.0
 */
// 修改api工程模块，根据已有的DeptClientService接口新建一个实现了FallbackFactory接口的类DeptClientServiceFallBackFactory
// fallbackFactory：集成Hystrix服务降级，还要记得在dept-feign模块 yml开启hystrix（因为fallbackFactory是在注解@FeignClient使用的）
@FeignClient(value = CommonConstants.MicroServiceName.DEPT, fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    boolean add(Dept dept);

    @RequestMapping(value = "/dept/get/{deptNo}", method = RequestMethod.GET)
    Dept get(@PathVariable("deptNo") Long deptNo);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    List<Dept> list();

}
