package com.edlison.design.decorator;

// 装饰器模式
public class DecoratorTest {
    public static void main(String[] args) {
        ConcreteComponent component = new ConcreteComponent();
        ConcreteDecoratorB componentB = new ConcreteDecoratorB(component);  // 改变顺序实现不同的效果
        ConcreteDecoratorA componentA = new ConcreteDecoratorA(componentB);
        componentA.operation();
    }
}

interface Component {
    void operation();
}

class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("拍照");
    }
}

abstract class Decorator implements Component {
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}

// 对扩展开放 对修改关闭
class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("美颜");
        component.operation();
    }
}

class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("滤镜");
        component.operation();
    }
}

// 应用场景
// 扩展一个类对功能，或给一个类添加附加职能

// 优点
// 1. 不改变原有对象的的情况下给一个对象扩展功能
// 2. 使用不同的组合实现不同的效果
// 3. 符合开闭原则