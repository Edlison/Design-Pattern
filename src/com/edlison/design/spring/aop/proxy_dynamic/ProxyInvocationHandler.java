package com.edlison.design.spring.aop.proxy_dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ProxyInvocationHandler
 *
 * @Author Edlison
 * @Date 2/2/21 10:53
 */
public class ProxyInvocationHandler implements InvocationHandler {
    // 被代理的接口
    private Object target;

    // 传入被代理的接口
    public void setTarget(Object target) {
        this.target = target;
    }

    // 生成代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    // 处理实例 返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object result = method.invoke(target, args);
        return result;
    }

    private void log(String msg) {
        System.out.println("[Log] " + msg);
    }
}
