package com.edlison.design.spring.aop.proxy_static;

/**
 * Host
 *
 * @Author Edlison
 * @Date 2/2/21 09:41
 */
public class Host implements Business{

    public void rent() {
        System.out.println("房东出租房屋");
    }
}
