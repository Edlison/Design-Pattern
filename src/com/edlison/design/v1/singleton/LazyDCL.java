package com.edlison.design.v1.singleton;

/**
 * LazyDCL
 * 双重检测的懒汉式
 *
 * @Author Edlison
 * @Date 2/1/21 17:18
 */
public class LazyDCL {

    private volatile static LazyDCL LAZYDCL;

    private LazyDCL() {

    }

    public static LazyDCL getInstance() {
        if (LAZYDCL == null) {
            synchronized (LazyDCL.class) {
                if (LAZYDCL == null) {
                    LAZYDCL = new LazyDCL();
                }
            }
        }
        return LAZYDCL;
    }
}
