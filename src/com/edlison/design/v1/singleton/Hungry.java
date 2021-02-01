package com.edlison.design.v1.singleton;

/**
 * Hungry
 * 饿汉式单例
 *
 * @Author Edlison
 * @Date 2/1/21 17:03
 */
public class Hungry {

    private final static Hungry HUNGRY = new Hungry();

    private Hungry() {

    }

    public static Hungry getInstance() {
        return HUNGRY;
    }

}
