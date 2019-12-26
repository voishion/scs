/*
 * @(#)RandomRule_ZY.java 2019/12/22
 *
 * Copyright (c) 2010 by rayootech.com. All rights reserved.
 */
package com.nuctech.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 依旧轮询策略，但是加上新需求，每个服务器要求被调用5次。也即
 * 以前是每台机器一次，现在是每台机器5次
 *
 * @author lilu
 * @date 2019/12/22
 * @since 1.0.0
 */
public class MyRandomRule extends AbstractLoadBalancerRule {
    // 当total等于5以后，指针才往下走
    private int total = 0;
    // total达到5次后，重新置为0，然后指针往下走，index=1
    private int index = 0; // 也就是Euraka中的第几个服务

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            if (total < 5) {
                server = upList.get(index);
                total++;
            } else {
                total = 0;
                index++;
                if (index >= upList.size()) {
                    index = 0;
                }
            }

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }

        return server;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
