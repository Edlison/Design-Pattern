package com.edlison.design.v1.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * EnumLazy
 *
 * @Author Edlison
 * @Date 2/1/21 18:12
 */
public enum EnumLazy {
    INSTANCE;

    public EnumLazy getInstance() {
        return INSTANCE;
    }
}

class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumLazy instanceA = EnumLazy.INSTANCE;
        Constructor<EnumLazy> constructor = EnumLazy.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        EnumLazy instanceB = constructor.newInstance();

        System.out.println(instanceA == instanceB);
    }
}
