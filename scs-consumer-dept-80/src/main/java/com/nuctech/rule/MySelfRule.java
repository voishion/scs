/*
 * @(#)MySelfRule.java 2019/12/22
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义Ribbon负载均衡算法
 *
 * @author lilu
 * @date 2019/12/22
 * @since 1.0.0
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        // Ribbon默认是轮询，我自定义为随机
//        return new RandomRule();
        // 指定LoadBalanced的算法 用我们自定义的规则算法
        return new MyRandomRule();
    }

}
