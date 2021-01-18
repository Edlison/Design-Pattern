package com.edlison.design.v0.template;

// 模版方法模式
public class TemplateTest {
    public static void main(String[] args) {
        SubClassA subClassA = new SubClassA();
        subClassA.operation();
    }
}

abstract class AbstractClass {
    public void operation() {

        // ...
        System.out.println("Operate...");
        System.out.println("Step1");
        System.out.println("Step2");
        System.out.println("Step3");

        templateMethod();
    }

    abstract protected void templateMethod();
}

class SubClassA extends AbstractClass {

    @Override
    protected void templateMethod() {
        System.out.println("SubClassA Execute...");
    }
}

class SubClassB extends AbstractClass {

    @Override
    protected void templateMethod() {
        System.out.println("SubClassB Execute...");
    }
}

// 模式定义
// 定义一个操作的算法骨架，而将一些步骤延迟到子类中
// Template Method 使得子类可以不改变一个算法的结构即可重新定义该算法的某些特定步骤