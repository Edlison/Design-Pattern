package com.edlison.design.v0.builder.v1;

public class BuilderV1Test {
    public static void main(String[] args) {
        DefaultConcreteProductBuilder defaultConcreteProductBuilder = new DefaultConcreteProductBuilder();
        Director directorDefault = new Director(defaultConcreteProductBuilder);
        Product productDefault = directorDefault.makeProduct("proName", "comName", "parA", "parB", "parC", "parD");
        System.out.println(productDefault);

        SpecialConcreteProductBuilder specialConcreteProductBuilder = new SpecialConcreteProductBuilder();
        Director directorSpecial = new Director(specialConcreteProductBuilder);
        Product productSpecial = directorSpecial.makeProduct("pro", "com", "A", "B", "C", "D");
        System.out.println(productSpecial);
    }
}

// 每个构造器独立 可扩展构造器
interface ProductBuilder {
    void builderProductName(String productName);

    void builderCompanyName(String companyName);

    void builderPartA(String partA);

    void builderPartB(String partB);

    void builderPartC(String partC);

    void builderPartD(String partD);

    Product build();
}

// 默认构造器
class DefaultConcreteProductBuilder implements ProductBuilder {
    private String productName;
    private String companyName;
    private String partA;
    private String partB;
    private String partC;
    private String partD;

    @Override
    public void builderProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void builderCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void builderPartA(String partA) {
        this.partA = partA;
    }

    @Override
    public void builderPartB(String partB) {
        this.partB = partB;
    }

    @Override
    public void builderPartC(String partC) {
        this.partC = partC;
    }

    @Override
    public void builderPartD(String partD) {
        this.partD = partD;
    }

    @Override
    public Product build() {
        return new Product(this.productName, this.companyName, this.partA, this.partB, this.partC, this.partD);
    }
}

// 特殊构造器
class SpecialConcreteProductBuilder implements ProductBuilder {
    private String productName;
    private String companyName;
    private String partA;
    private String partB;
    private String partC;
    private String partD;

    @Override
    public void builderProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void builderCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void builderPartA(String partA) {
        this.partA = partA + "Special";
    }

    @Override
    public void builderPartB(String partB) {
        this.partB = partB + "Special";
    }

    @Override
    public void builderPartC(String partC) {
        this.partC = partC + "Special";
    }

    @Override
    public void builderPartD(String partD) {
        this.partD = partD + "Special";
    }

    @Override
    public Product build() {
        return new Product(this.productName, this.companyName, this.partA, this.partB, this.partC, this.partD);
    }
}

class Director {
    private ProductBuilder builder;

    public Director(ProductBuilder builder) {
        this.builder = builder;
    }

    public Product makeProduct(String productName, String companyName, String partA, String partB, String partC, String partD) {
        builder.builderProductName(productName);
        builder.builderCompanyName(companyName);
        builder.builderPartA(partA);
        builder.builderPartB(partB);
        builder.builderPartC(partC);
        builder.builderPartD(partD);

        return builder.build();
    }
}

class Product {
    private String productName;
    private String companyName;
    private String partA;
    private String partB;
    private String partC;
    private String partD;

    public Product() {

    }

    public Product(String productName, String companyName, String partA, String partB, String partC, String partD) {
        this.productName = productName;
        this.companyName = companyName;
        this.partA = partA;
        this.partB = partB;
        this.partC = partC;
        this.partD = partD;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public String getPartD() {
        return partD;
    }

    public void setPartD(String partD) {
        this.partD = partD;
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