package com.edlison.design.spring.aop.proxy_custom;

/**
 * CustomClient
 *
 * @Author Edlison
 * @Date 2/2/21 17:32
 */
public class CustomClient {
    public static void main(String[] args) {
        // 需要代理的接口
        IndexService indexService = new IndexServiceImpl();
        // 实例化 自定义代理接口需要进行的处理类
        CustomInvocationHandler customInvocationHandler = new CustomInvocationHandler(indexService);
        // 实例化 自定义的代理类
        CustomProxy customProxy = new CustomProxy();
        // 获取代理 需要传入代理的接口及自定义的处理类
        IndexService proxy = (IndexService) customProxy.getProxy(indexService, customInvocationHandler);
        // 执行测试
        proxy.add();
    }
}
