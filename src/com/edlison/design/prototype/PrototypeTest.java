package com.edlison.design.prototype;

import java.io.*;

// 原型模式
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        BaseInfo baseInfo = new BaseInfo("Helo");
        Product product = new Product("s1", "s2", 1, 2, 3, baseInfo);
        Product clone = product.clone();

        System.out.println("product = " + product);
        System.out.println("clone = " + clone);

        product.getBaseInfo().setCompanyName("world");
        System.out.println("product = " + product);
        System.out.println("clone = " + clone);

    }
}

class BaseInfo implements Cloneable, Serializable{
    private String companyName;

    public BaseInfo(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        return ((BaseInfo) super.clone());
    }

    @Override
    public String toString() {
        return super.hashCode() + " BaseInfo{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}

class Product implements Cloneable, Serializable{
    private String string1;
    private String string2;
    private Integer integer1;
    private Integer integer2;
    private Integer integer3;
    private BaseInfo baseInfo;

    public Product(String string1, String string2, Integer integer1, Integer integer2, Integer integer3, BaseInfo baseInfo) {
        this.string1 = string1;
        this.string2 = string2;
        this.integer1 = integer1;
        this.integer2 = integer2;
        this.integer3 = integer3;
        this.baseInfo = baseInfo;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    @Override
    protected Product clone() throws CloneNotSupportedException {
//        v1
//        Product clone = ((Product) super.clone());
//        BaseInfo baseInfo = this.baseInfo.clone();
//        clone.setBaseInfo(baseInfo);
//
//        return clone;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            // 当前JVM数据写入流中
            ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        try {
            // 内存中数据恢复出来
            ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
            Product product = ((Product) ois.readObject());
            return product;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return super.hashCode() + " Product{" +
                "string1='" + string1 + '\'' +
                ", string2='" + string2 + '\'' +
                ", integer1=" + integer1 +
                ", integer2=" + integer2 +
                ", integer3=" + integer3 +
                ", baseInfo=" + baseInfo +
                '}';
    }
}

// 应用场景
// 当代码不应该依赖于需要复制的对象的具体类时，使用Prototype
//
// 优点
// 1. 不耦合具体类的情况下克隆对象
// 2. 避免重复的初始化代码
// 3. 更方便的构建复杂对象
