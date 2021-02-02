package com.edlison.design.spring.aop.proxy_custom;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * CustomInvocationHandler
 *
 * @Author Edlison
 * @Date 2/2/21 17:23
 */
public class CustomInvocationHandler implements InvocationHandler {

    private IndexService indexService;

    public CustomInvocationHandler(IndexService indexService) {
        this.indexService = indexService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {  // TODO Proxy的作用？
        logBefore(method.getName());
        Object res = method.invoke(indexService, args);
        logAfter(indexService.getClass().getName());
        return res;
    }

    // 以下定义 前后装饰方法
    private void logBefore(String msg) {
        System.out.println("[Log] " + msg);
    }

    private void logAfter(String msg) {
        System.out.println("[Log] " + msg + "has been done!");
    }
}
