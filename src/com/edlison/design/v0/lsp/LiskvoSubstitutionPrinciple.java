package com.edlison.design.v0.lsp;

import java.util.HashMap;
import java.util.Map;

// 里氏替换原则
public class LiskvoSubstitutionPrinciple {
    public static void main(String[] args) {
        UserService userServiceA = new UserService(new CacheManager());
        userServiceA.biz("keyA");   // 数据库中获取 ValueA
        userServiceA.biz("keyA");   // keyA 命中 ValueA
        userServiceA.biz("keyB");
        userServiceA.biz("keyB");

        UserService userServiceB = new UserService(new RedisCacheManager());
        userServiceB.biz("keyB");   // 数据库中获取 null
        userServiceB.biz("keyB");   // keyB 命中 empty
    }
}

class UserService {
    private static Map<String, String> db = new HashMap<>();

    private CacheManager cacheManager;

    static {
        db.put("keyA", "ValueA");
    }

    public UserService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public String biz(String key) {
        String value = cacheManager.get(key);

        if (value == null) {
            value = dbData(key);
            cacheManager.put(key, value);
        } else {
            System.out.println(key + " 命中 " + value);
        }

        return value;
    }

    private String dbData(String key) {
        String value = db.get(key);
        System.out.println("数据库中获取 " + value);
        return value;
    }
}

class CacheManager {
    private Map<String, String> cache = new HashMap<>();

    public String get(String key) {
        String o = cache.get(key);

        if (o == null || o.equals("")) {
            return null;
        } else {
            return o;
        }
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }
}

class RedisCacheManager extends CacheManager {
    private Map<String, String> redisCache = new HashMap<>();

    private static final String empty = "empty";

    @Override
    public String get(String key) {
        String o = redisCache.get(key);
        if (o == null || o.equals("")) {
            return null;
        } else {
            return o;
        }
    }

    @Override
    public void put(String key, String value) {
        if (value == null || value.equals("")) {
            redisCache.put(key, empty);     // 不满足里氏替换原则
        } else {
            redisCache.put(key, value);
        }
    }
}

// 里氏替换原则
// 说明：子类对象能够替换程序中父类出现的任何地方，并且保证原来程序的逻辑行为不变及正确性不被破坏。

// 可以利用面向对象编程的多态性来实现，多态和里氏替换原则有点类似，但他们的关注角度是不一样的，多态是面向对象编程的一种特性，而里氏原则是一种设计原则，用来指导继承关系中子类该如何设计。
// 子类的设计要确保在替换父类的时候，不改变原有程序的逻辑及不破坏原有程序的正确性。
// 具体实现可以理解为：子类在设计的时候要遵循父类的行为约定。父类定义子类的行为，子类可以改变方法内部的实现逻辑，但不改变方法原有的行为约定。
// 接口 方法 声明要实现的功能 对参数值，返回值，异常值的约定甚至包括的任何特殊说明