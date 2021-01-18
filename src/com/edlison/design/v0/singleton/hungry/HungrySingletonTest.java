package com.edlison.design.v0.singleton.hungry;

public class HungrySingletonTest {
    public static void main(String[] args) {
        HungrySingleton instance1 = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}

// 饿汉模式
// 类加载的初始化阶段就完成了实例的初始化。 本质上是借助jvm的类记载机制保证了实例的唯一性。
// 类加载过程
// 1. 加载二进制数据到内存中，生成对应的Class数据结构
// 2. 连接：a. 验证 b. 准备(给类的静态成员变量赋默认值) c. 解析
// 3. 初始化：给类的静态变量赋初值
// 只有在真正使用对应的类时才会触发初始化
class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}