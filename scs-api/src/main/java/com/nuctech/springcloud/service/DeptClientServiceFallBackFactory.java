/*
 * @(#)DeptClientServiceFallBackFactory.java 2019/12/22
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud.service;

import com.nuctech.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 统一处理DeptClientService这个类中的熔断，主业务与熔断方法解耦
 *
 * @author lilu
 * @date 2019/12/22
 * @since 1.0.0
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long deptNo) {
                return new Dept().setDeptNo(deptNo)
                        .setDeptName(String.format("没有编号为%d的部门信息，Consumer客户端提供的降级信息，此刻服务Provider已经关闭", deptNo))
                        .setDbSource("没有这个数据库");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
