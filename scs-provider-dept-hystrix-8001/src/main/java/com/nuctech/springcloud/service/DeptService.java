/*
 * @(#)DeptService.java 2019/12/21
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud.service;

import com.nuctech.springcloud.entities.Dept;

import java.util.List;

/**
 * @author lilu
 * @date 2019/12/21
 * @since 1.0.0
 */
public interface DeptService {
    /**
     * 插入
     *
     * @param dept
     * @return
     */
    boolean add(Dept dept);

    /**
     * 根据id查找
     *
     * @param deptNo
     * @return
     */
    Dept get(Long deptNo);

    /**
     * 查询全部
     *
     * @return
     */
    List<Dept> list();
}
