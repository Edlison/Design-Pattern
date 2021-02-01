package com.edlison.design.v1.singleton;

/**
 * Lazy
 * 懒汉模式
 *
 * @Author Edlison
 * @Date 2/1/21 17:14
 */
public class Lazy {

    private static Lazy LAZY;

    private Lazy() {

    }

    public static Lazy getInstance() {
        if (LAZY == null) {
            LAZY = new Lazy();
        }
        return LAZY;
    }
}
