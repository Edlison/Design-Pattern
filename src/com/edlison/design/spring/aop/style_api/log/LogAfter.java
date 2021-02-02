package com.edlison.design.spring.aop.style_api.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * LogAfter
 *
 * @Author Edlison
 * @Date 2/2/21 21:56
 */
public class LogAfter implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("[Log After]ClassName: " + target.getClass().getSimpleName() + " MethodName: " + method.getName());
    }
}