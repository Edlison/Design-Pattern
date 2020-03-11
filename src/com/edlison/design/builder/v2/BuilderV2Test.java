package com.edlison.design.builder.v2;

public class BuilderV2Test {
    public static void main(String[] args) {
        Product.Builder builder = new Product.Builder().productName("proName").companyName("comName").partA("A").partB("B").partC("C").partD("D");
        builder.companyName("Hello Company");
        Product product = builder.build();
        System.out.println(product);
    }
}

class Product {
    private final String productName;
    private final String companyName;
    private final String partA;
    private final String partB;
    private final String partC;
    private final String partD;

    // 私有构造方法1 ！！！
    private Product(String productName, String companyName, String partA, String partB, String partC, String partD) {
        this.productName = productName;
        this.companyName = companyName;
        this.partA = partA;
        this.partB = partB;
        this.partC = partC;
        this.partD = partD;
    }

    // 私有构造方法2 ！！！
    private Product(Builder builder) {
        this.productName = builder.productName;
        this.companyName = builder.companyName;
        this.partA = builder.partA;
        this.partB = builder.partB;
        this.partC = builder.partC;
        this.partD = builder.partD;
    }

    static class Builder {
        private String productName;
        private String companyName;
        private String partA;
        private String partB;
        private String partC;
        private String partD;

        Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        Builder partA(String partA) {
            this.partA = partA;
            return this;
        }

        Builder partB(String partB) {
            this.partB = partB;
            return this;
        }

        Builder partC(String partC) {
            this.partC = partC;
            return this;
        }

        Builder partD(String partD) {
            this.partD = partD;
            return this;
        }

        Product build() {
            return new Product(this);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                ", partD='" + partD + '\'' +
                '}';
    }
}

// 应用场景
// 需要生成的对象具有复杂的内部结构
// 需要生成的对象内部属性本身相互依赖
// 与不可变对象配合使用

// 优点
// 建造者独立 易扩展
// 便于控制细节风险