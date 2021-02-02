package com.edlison.design.v1.reflection;

/**
 * Reflect
 *
 * @Author Edlison
 * @Date 2/2/21 13:35
 */
public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();

        // 通过对象获得
        Class c1 = person.getClass();

        // 通过forName获得
        Class c2 = Class.forName("com.edlison.design.v1.reflection.Student");

        // 通过类.class获得
        Class c3 = Student.class;

        // 内置类型的Type属性
        Class c4 = Integer.TYPE;

        // 通过子类获取父类
        Class c5 = Student.class.getSuperclass();
    }
}

class Person {
    String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person {

    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person {

    public Teacher() {
        this.name = "老师";
    }
}