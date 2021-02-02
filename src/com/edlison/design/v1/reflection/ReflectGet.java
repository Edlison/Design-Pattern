package com.edlison.design.v1.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ReflectGet
 *
 * @Author Edlison
 * @Date 2/2/21 14:47
 */
public class ReflectGet {
    public static void main(String[] args) throws NoSuchMethodException {
        Class c = Person.class;

        // 获得类名
        System.out.println("c.getName() = " + c.getName());
        System.out.println("c.getSimpleName() = " + c.getSimpleName());

        // 获得类的属性
        Field[] fields = c.getFields();  // public属性
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
        fields = c.getDeclaredFields();  // 所有属性
        for (Field field : fields) {
            System.out.println("declaredField = " + field);
        }

        // 获得类的方法
        Method[] methods = c.getMethods();  // 本类及父类全部的public方法
        for (Method method : methods) {
            System.out.println("method = " + method);
        }
        methods = c.getDeclaredMethods();  // 本类的所有方法
        for (Method method : methods) {
            System.out.println("method = " + method);
        }
        Method method = c.getMethod("setAge", int.class);  // 需要指定形参的类型，因为可能会重载！！！
        System.out.println("method = " + method);

        // 获得构造器
        Constructor[] constructors = c.getConstructors();  // 获得public方法
        for (Constructor constructor : constructors) {
            System.out.println("constructor = " + constructor);
        }
        constructors = c.getDeclaredConstructors();  // 获得本类全部
        for (Constructor constructor : constructors) {
            System.out.println("constructor = " + constructor);
        }
        Constructor constructor = c.getConstructor(String.class, int.class);  // 获取指定构造器，同样需要传形参的class类，可能会重载！！！
        System.out.println("constructor = " + constructor);
    }
}
