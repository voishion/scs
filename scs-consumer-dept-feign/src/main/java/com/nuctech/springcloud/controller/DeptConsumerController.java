/*
 * @(#)DeptConsumerController.java 2019/12/21
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud.controller;

import com.nuctech.springcloud.entities.Dept;
import com.nuctech.springcloud.service.DeptClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private final DeptClientService deptClientService;

    @RequestMapping(value = "/add")
    public boolean add(Dept dept) {
        return this.deptClientService.add(dept);
    }

    @RequestMapping(value = "/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Long deptNo) {
        return this.deptClientService.get(deptNo);
    }

    @RequestMapping(value = "/list")
    public List<Dept> list() {
        return this.deptClientService.list();
    }

}
