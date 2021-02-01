package com.edlison.design.v1.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * UltimateLazy
 * 可能会通过反射来破解单例模式
 *
 * @Author Edlison
 * @Date 2/1/21 17:43
 */
public class UltimateLazy {

    private volatile static UltimateLazy ULTIMATELAZY;

    private static boolean flag = false;

    private UltimateLazy() {
        synchronized (UltimateLazy.class) {
            if (ULTIMATELAZY != null) {
                throw new RuntimeException("error");
            }
        }

        synchronized (UltimateLazy.class) {
            if (flag == false) {
                flag = true;
            } else {
                throw new RuntimeException("error");
            }
        }
    }

    private static UltimateLazy getInstance() {
        if (ULTIMATELAZY == null) {
            synchronized (UltimateLazy.class) {
                if (ULTIMATELAZY == null) {
                    ULTIMATELAZY = new UltimateLazy();
                }
            }
        }
        return ULTIMATELAZY;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        UltimateLazy instanceA = UltimateLazy.getInstance();

        Constructor<UltimateLazy> declaredConstructor = UltimateLazy.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        UltimateLazy instanceB = declaredConstructor.newInstance();
    }
}
