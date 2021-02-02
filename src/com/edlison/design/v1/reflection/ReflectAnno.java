package com.edlison.design.v1.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * ReflectAnno
 *
 * @Author Edlison
 * @Date 2/2/21 15:53
 */
public class ReflectAnno {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Class<User> c = User.class;

        // 获得类上的注解
        Annotation[] annotations = c.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
        }

        // 获取注解的值
        Table target = c.getAnnotation(Table.class);
        System.out.println(target.value());

        // 获取类的Field
        java.lang.reflect.Field name = c.getDeclaredField("name");
        // 获取Field上的注解
        Field nameAnnotation = name.getAnnotation(Field.class);
        // 获取注解的值
        System.out.println("nameAnnotation.colName() = " + nameAnnotation.colName());
        System.out.println("nameAnnotation.type() = " + nameAnnotation.type());
        System.out.println("nameAnnotation.length() = " + nameAnnotation.length());

        // 获取类的Method
        Method setPassword = c.getDeclaredMethod("setPassword", String.class);
        // 获取Method上的注解
        setPassword.getAnnotations();
    }
}

@Table("user")
class User {
    @Field(colName = "user_id", type = "int", length = 10)
    private int id;
    @Field(colName = "user_name", type = "varchar", length = 10)
    private String name;
    @Field(colName = "user_password", type = "varchar", length = 64)
    private String password;

    public User() {
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Field {
    String colName();
    String type();
    int length();
}