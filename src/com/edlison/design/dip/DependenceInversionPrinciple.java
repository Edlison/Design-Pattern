package com.edlison.design.dip;

public class DependenceInversionPrinciple {
    public static void main(String[] args) {

    }
}

// 依赖倒置原则
// 高层模块不要依赖底层模块。高层模块与底层模块应该通过抽象来互相依赖。
// 除此之外，抽象不要依赖具体实现细节，具体实现细节依赖抽象。

// 例如：Tomcat(高层) -> Servlet(抽象) -> Code(底层)
// Tomcat高层Code底层均实现Servlet规范 通过Servlet互相依赖