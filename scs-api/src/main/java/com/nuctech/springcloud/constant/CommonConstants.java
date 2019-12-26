/*
 * @(#)CommonConstants.java 2019/12/22
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud.constant;

/**
 * 通用常量接口
 *
 * @author lilu
 * @date 2019/12/22
 * @since 1.0.0
 */
public interface CommonConstants {
    /**
     * 系统常量
     */
    interface System {
        /**
         * 根包路径
         */
        String BASE_PACKAGES = "com.nuctech.springcloud";
    }
    /**
     * 微服务名称
     */
    interface MicroServiceName {
        /**
         * 部门微服务
         */
        String DEPT = "SCS-DEPT";
    }
}
