package com.edlison.design.spring.aop.style_aspect;

/**
 * CustomAspect
 *
 * @Author Edlison
 * @Date 2/2/21 22:42
 */
public class CustomAspect {
    public void before() {
        System.out.println("[Log] Before...");
    }

    public void after() {
        System.out.println("[Log] After...");
    }
}
