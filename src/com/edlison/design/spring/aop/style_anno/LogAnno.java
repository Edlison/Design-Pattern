package com.edlison.design.spring.aop.style_anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * LogAnno
 *
 * @Author Edlison
 * @Date 2/2/21 23:05
 */
@Aspect
@Component
public class LogAnno {

    @Before("execution(* com.edlison.design.spring.aop.style_anno.LoginServiceImpl.*(..))")
    public void before() {
        System.out.println("[Log] Before...");
    }

    @After("execution(* com.edlison.design.spring.aop.style_anno.LoginServiceImpl.*(..))")
    public void after() {
        System.out.println("[Log] After...");
    }

    @Around("execution(* com.edlison.design.spring.aop.style_anno.LoginServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[Log] Point Start");
        joinPoint.proceed();
        System.out.println("[Log] Point End");
        System.out.println("joinPoint.getSignature() = " + joinPoint.getSignature());
    }
}
