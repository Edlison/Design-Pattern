package com.edlison.design.v1.anno;

import java.lang.annotation.*;

/**
 * MetaAnno
 *
 * @Author Edlison
 * @Date 2/2/21 11:58
 */
@MyAnno
public class MetaAnno {

    @MyAnno
    public void test1() {
        System.out.println("test1");
    }

    @MyAnnoPlus(value = "", age = 1)
    public void test2() {
        System.out.println("test2");
    }
}

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnno {

}

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnoPlus {
    String value();
    String name() default "edlison";
    int id() default -1;
    int age();
}