package com.edlison.design.spring.aop.proxy_custom;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * CustomProxy
 *
 * @Author Edlison
 * @Date 2/2/21 17:23
 */
public class CustomProxy {

    public Object getProxy(IndexService indexService, InvocationHandler invocationHandler) {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), indexService.getClass().getInterfaces(), invocationHandler);
    }
}
