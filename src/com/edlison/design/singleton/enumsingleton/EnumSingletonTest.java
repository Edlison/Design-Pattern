package com.edlison.design.singleton.enumsingleton;

public enum EnumSingletonTest {
    INSTANCE;

    public void print() {
        System.out.println(this.hashCode());
    }
}

class Test {
    public static void main(String[] args) {
        EnumSingletonTest instance1 = EnumSingletonTest.INSTANCE;
        EnumSingletonTest instance2 = EnumSingletonTest.INSTANCE;
        System.out.println(instance1 == instance2);
    }
}