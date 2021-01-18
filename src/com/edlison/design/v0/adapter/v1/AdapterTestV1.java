package com.edlison.design.v0.adapter.v1;

// Object Adapter 对象适配器
public class AdapterTestV1 {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);

        adapter.output_5v();
    }
}

class Adaptee {
    public int output_220v() {
        return 220;
    }
}

interface Target {
    int output_5v();
}

class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output_5v() {
        int input = adaptee.output_220v();
        System.out.println(String.format("输入电压：%dv -> 输出电压： %dv ", input, 5));
        return 5;
    }
}

// 模式定义
// 将一个类的接口转换成用户希望的另一个接口。Adapter模式使那些由于接口不兼容而不能一起工作的类可以一起工作。

// 应用场景
// 希望使用某些现有类，但其接口与其它代码不兼容时，使用适配器类。
// 希望重用几个现有的子类，这些子类缺少一些不能添加到超类中的公共功能时，使用适配器模式。

// 优点
// 1. 符合单一职责原则
// 2. 符合开闭原则