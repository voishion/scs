/*
 * @(#)ConfigBean.java 2019/12/21
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.springcloud.config;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lilu
 * @date 2019/12/21
 * @since 1.0.0
 */
@Configuration
public class ConfigBean {
    // =====
    /**
     * @LoadBalanced
     * Spring Cloud Ribbon是基于Netflix Ribbon实现的一套 客户端 负载均衡的工具。
     * Ribbon默认负载均衡算法为轮询算法，每个微服务访问一次
     * 总结：Ribbon其实就是一个软负载均衡的客户端组件，它可以和其他所需请求的客户端结合使用，和Eureka结合只是其中的一个实例
     */
    // =====

    /**
     * 配置RestTemplate
     * 通过RestTemplate调用提供者服务 ，发送rest请求
     * 提供了多种访问http服务的方法，
     * 针对于访问rest服务<strong>客户端</strong>的调用的模板类
     *
     * @author lilu
     * @date 2019/12/22 13:17
     * @since 1.0.0
     *
     * @param
     * @return org.springframework.web.client.RestTemplate
     */
    @Bean
    @LoadBalanced // 使用@LoadBalanced注解赋予RestTemplate负载均衡的能力 默认轮询
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 指定LoadBalanced的负载均衡算法
     *
     * @author lilu
     * @date 2019/12/22 13:19
     * @since 1.0.0
     *
     * @param
     * @return com.netflix.loadbalancer.IRule
     */
    @Bean
    public IRule myRule() {
        /*
        // Ribbon自带负载均衡算法
        return new RoundRobinRule();            // 轮询[默认]
        return new RandomRule();                // 随机
        return new AvailabilityFilteringRule(); // 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数量超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问
        return new AvailabilityFilteringRule(); // 根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大被选中的概率越高。刚启动时如果统计信息不足，则使用RoundRobinRule策略，等统计信息足够，会切换到WeightedResponseTimeRule
        return new RetryRule();                 // 先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
        return new BestAvailableRule();         // 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
        return new ZoneAvoidanceRule();         // 默认规则,复合判断server所在区域的性能和server的可用性选择服务器
         */
        return new RetryRule();
    }
}
