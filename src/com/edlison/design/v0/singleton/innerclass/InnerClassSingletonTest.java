package com.edlison.design.v0.singleton.innerclass;

public class InnerClassSingletonTest {
    public static void main(String[] args) {
        new Thread(
                () -> {
                    InnerClassSingleton instance = InnerClassSingleton.getInstance();
                    System.out.println(instance);
                }
        ).start();

        new Thread(
                () -> {
                    InnerClassSingleton instance = InnerClassSingleton.getInstance();
                    System.out.println(instance);
                }
        ).start();
    }
}

//静态内部类
// 1) 本质上是利用类的加载机制保证线程安全
// 2) 只有在时机使用的时候才会触发类的初始化，所以也是懒加载的一种形式
class InnerClassSingleton {
    private static class InnerClassHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton() {

    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }
}