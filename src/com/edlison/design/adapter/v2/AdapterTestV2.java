package com.edlison.design.adapter.v2;

// Class Adapter
public class AdapterTestV2 {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.output_5v();
        adapter.output_220v();  // 可以使用父类方法 对接口造成污染
    }
}

class Adaptee {
    public int output_220v() {
        return 220;
    }
}

interface Target {
    int output_5v();
}

class Adapter extends Adaptee implements Target {

    @Override
    public int output_5v() {

        System.out.println(String.format("输入电压：%dv -> 输出电压： %dv ", output_220v(), 5));

        return 5;
    }
}