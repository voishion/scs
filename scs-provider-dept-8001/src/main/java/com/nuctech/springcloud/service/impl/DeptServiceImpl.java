/*
 * @(#)DeptServiceImpl.java 2019/12/21
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud.service.impl;

import com.nuctech.springcloud.dao.DeptDao;
import com.nuctech.springcloud.entities.Dept;
import com.nuctech.springcloud.service.DeptService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lilu
 * @date 2019/12/21
 * @since 1.0.0
 */
@Service
@AllArgsConstructor
public class DeptServiceImpl implements DeptService {

    private final DeptDao deptDao;

    @Override
    public boolean add(Dept dept) { return this.deptDao.add(dept); }

    @Override
    public Dept get(Long deptNo) {
        return this.deptDao.get(deptNo);
    }

    @Override
    public List<Dept> list() {
        return this.deptDao.list();
    }
}
