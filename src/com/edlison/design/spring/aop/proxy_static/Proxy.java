package com.edlison.design.spring.aop.proxy_static;

/**
 * Proxy
 *
 * @Author Edlison
 * @Date 2/2/21 09:40
 */
public class Proxy implements Business{
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void fee() {
        System.out.println("收费");
    }

    @Override
    public void rent() {
        log("出租房屋了");
        host.rent();
    }

    private void log(String msg) {
        System.out.println("[Log] " + msg);
    }
}
