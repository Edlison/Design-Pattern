package com.edlison.design.v0.factory.method;

// 工厂方法模式
public class FactoryMethod {
    public static void main(String[] args) {
        ConcreteProductA appA = new ConcreteProductA();
        Product productA = appA.createProduct();
        productA.method();

        Application appB = new ConcreteProductB();
        Product productB = appB.getObject();
        productB.method();
    }
}

interface Product {
    public void method();
}

class ProductA implements Product{
    public void method() {
        System.out.println("ProductA.method execute!");
    }
}

class ProductB implements Product{
    public void method() {
        System.out.println("ProductB.method execute!");
    }
}

class SimpleFactory {// 简单工厂模式 通过不同的参数实例化不同的对象
    public static Product createProduct(String type) {
        if (type.equals("A")) {
            // ...

            return new ProductA();
        } else if (type.equals("B")) {
            // ...

            return new ProductB();
        } else {
            // ...

            return null;
        }
    }
}

abstract class Application {
    abstract Product createProduct();// *FactoryMethod 工厂方法 实现延迟到子类 是稳定的

    Product getObject() {
        // ...init

        Product product = createProduct();
        return product;
    }
}

// 具体的实现 不稳定
class ConcreteProductA extends Application {

    @Override
    Product createProduct() {// 子类进行具体实现
        // ...

        return new ProductA();
    }
}

class ConcreteProductB extends Application {

    @Override
    Product createProduct() {// 子类进行具体实现
        // ...

        return new ProductB();
    }
}

// 模式定义
// 定义一个用于创建对象的接口，让子类决定实例化哪一个类。Factory Method使得一个类的实例话延迟到子类。
// 应用场景
// 1)不知道该使用对象的确切类型时
// 2)希望为库或框架提供扩展其内部组件的方法时
// 优点
// 1)将具体产品与创建者解藕
// 2)符合单一职责原则
// 3)符合开闭原则