package com.edlison.design.spring.aop.proxy_dynamic;

/**
 * UserServiceImpl
 *
 * @Author Edlison
 * @Date 2/2/21 10:59
 */
public class UserServiceImpl implements UserService{

    @Override
    public void add() {
        System.out.println("执行增操作");
    }

    @Override
    public void delete() {
        System.out.println("执行删操作");
    }

    @Override
    public void update() {
        System.out.println("执行改操作");
    }

    @Override
    public void query() {
        System.out.println("执行查操作");
    }
}
