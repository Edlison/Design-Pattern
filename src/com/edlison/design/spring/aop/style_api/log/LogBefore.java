package com.edlison.design.spring.aop.style_api.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Log
 *
 * @Author Edlison
 * @Date 2/2/21 21:50
 */
public class LogBefore implements MethodBeforeAdvice {

    @Override
    // method: 要执行的目标对象的方法，objects: 参数，o: 目标对象
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("[Log Before]ClassName: " + o.getClass().getSimpleName() + " MethodName: " + method.getName());
    }
}
