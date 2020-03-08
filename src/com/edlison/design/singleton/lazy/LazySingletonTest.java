package com.edlison.design.singleton.lazy;

public class LazySingletonTest {
    public static void main(String[] args) {

        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();

    }
}

// 懒汉模式
class LazySingleton {
    private volatile static LazySingleton instance;// 3. 编译器(JIT) CPU 可能会对指令进行重排列，导致使用尚未被初始化的实例，添加volatile关键字修饰防止指令重排列。

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {

        if (instance == null) {// 2. double check加锁优化
            synchronized (LazySingleton.class) {// 1. 线程安全问题
                if (instance == null)
                    instance = new LazySingleton();
                    // new 字节码层
                    // JIT CPU
                    // 1. 分配空间
                    // 2. 初始化
                    // 3. 引用赋值
            }
        }

        return instance;
    }
}



