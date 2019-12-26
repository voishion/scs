/*
 * @(#)Dept.java 2019/12/21
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 部门表实体类
 *
 * @author lilu
 * @date 2019/12/21
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
// 必须序列化
public class Dept implements Serializable {
    /**
     * 部门编码 主键
     */
    private Long deptNo;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 数据库名称(来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库)
     */
    private String dbSource;
}
