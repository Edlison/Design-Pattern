package com.edlison.design.spring.aop.proxy_static;

/**
 * Client
 *
 * @Author Edlison
 * @Date 2/2/21 09:40
 */
public class Client {
    public static void main(String[] args) {
        Host host = new Host();

        Proxy proxy = new Proxy(host);

        proxy.rent();
    }
}
