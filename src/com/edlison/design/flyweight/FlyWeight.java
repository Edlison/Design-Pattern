package com.edlison.design.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlyWeight {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3, 4, TreeFactory.getTree("x", "0000"));
        TreeNode treeNode2 = new TreeNode(3, 4, TreeFactory.getTree("x", "0000"));

        TreeNode treeNode3 = new TreeNode(12, 15, TreeFactory.getTree("y", "8080"));
        TreeNode treeNode4 = new TreeNode(12, 15, TreeFactory.getTree("y", "80"));
    }
}

class TreeFactory {
    private static Map<String, Tree> map = new ConcurrentHashMap<>();

    public static Tree getTree(String name, String data) {
        if (map.containsKey(name)) {
            return map.get(name);
        } else {
            Tree tree = new Tree(name, data);
            map.put(name, tree);
            return tree;
        }
    }
}

class TreeNode {
    private double x;
    private double y;
    private Tree tree;

    public TreeNode(double x, double y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }
}

// 不可变对象String, Integer, Long
// String 创建后放入常量池中 再次定义搜索常量池
class Tree {
    private final String name;
    private final String data;

    public Tree(String name, String data) {
        this.name = name;
        this.data = data;
        System.out.println("name = " + name + " has been created!");
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}

// 模式定义：
// 运用共享技术有效的支持大量细粒度的对象（1. 数据一致性 2. 不可变）。
// 优点：
// 如果系统有大量类似的对象，可以节省大量的CPU及内存资源。
