package com.edlison.design.spring.aop.proxy_dynamic;

/**
 * Client
 *
 * @Author Edlison
 * @Date 2/2/21 10:58
 */
public class Client {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();

        proxyInvocationHandler.setTarget(userService);

        UserService proxy = (UserService) proxyInvocationHandler.getProxy();

        proxy.delete();
    }
}
