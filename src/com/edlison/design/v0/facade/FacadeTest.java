package com.edlison.design.v0.facade;

// 门面模式
public class FacadeTest {
    public static void main(String[] args) {
        Client1 client1 = new Client1();
        client1.doSomething1();

        Client2 client2 = new Client2();
        client2.doSomething2();
    }
}

class Client1 {
    Facade facade = new Facade();

    public void doSomething1() {
        facade.doFacade();
    }
}

class Client2 {
    Facade facade = new Facade();

    public void doSomething2() {
        facade.doFacade();
    }
}

class Facade {
    System1 system1 = new System1();
    System2 system2 = new System2();
    System3 system3 = new System3();

    public void doFacade() {
        system1.method1();
        system2.method2();
        system3.method3();
    }

}

class System1 {
    public void method1() {
        System.out.println("This is Sys1");
    }
}

class System2 {
    public void method2() {
        System.out.println("This is Sys2");
    }
}

class System3 {
    public void method3() {
        System.out.println("This is Sys3");
    }
}

// 应用场景
// 1. 使用复杂子系统的有限但直接的接口
// 2. 将子系统组织成层(Controller - Service)

// 优点
// 简化客户端的调用