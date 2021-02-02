package com.edlison.design.spring.aop.proxy_custom;

/**
 * IndexServiceImpl
 *
 * @Author Edlison
 * @Date 2/2/21 17:24
 */
public class IndexServiceImpl implements IndexService{

    @Override
    public void add() {
        System.out.println("执行增加操作");
    }
}
