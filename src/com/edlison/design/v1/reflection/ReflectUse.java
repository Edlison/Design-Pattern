package com.edlison.design.v1.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ReflectUse
 *
 * @Author Edlison
 * @Date 2/2/21 15:14
 */
public class ReflectUse {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 拿到类的Class对象
        Class c = Person.class;

        // 获取构造器（在Java9后使用Class对象直接创建实例的方法已经被抛弃了）
        Constructor constructorA = c.getDeclaredConstructor(null);
        Constructor constructorB = c.getDeclaredConstructor(String.class, int.class);

        // 通过构造器创建实例
        Person person = (Person) constructorA.newInstance(null);
        System.out.println("person = " + person);
        Person personB = (Person) constructorB.newInstance("Edlison", 18);
        System.out.println("personB = " + personB);

        // 通过Class对象获取其中的方法
        Method setName = c.getMethod("setName", String.class);

        // 执行该方法： 执行的对象 形参
        setName.invoke(personB, "edlison");
        System.out.println("personB = " + personB);

        // 通过Class对象获取其中的属性
        Field age = c.getDeclaredField("age");
        age.setAccessible(true);  // 由于private限制 需要先设置Accessible才可以对其进行操作
        age.set(personB, 10);
        System.out.println("personB = " + personB);
    }
}
