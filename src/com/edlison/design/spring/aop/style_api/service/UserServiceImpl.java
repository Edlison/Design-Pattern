package com.edlison.design.spring.aop.style_api.service;

import org.springframework.stereotype.Component;

/**
 * UserServiceImpl
 *
 * @Author Edlison
 * @Date 2/2/21 21:48
 */
@Component
public class UserServiceImpl implements UserService{

    @Override
    public void add() {
        System.out.println("执行增加操作");
    }

    @Override
    public void delete() {
        System.out.println("执行删除操作");
    }

    @Override
    public void update() {
        System.out.println("执行修改操作");
    }

    @Override
    public void query() {
        System.out.println("执行查询操作");
    }
}
