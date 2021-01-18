package com.edlison.design.v0.strategy.v1;

// 非策略模式 不利于后期添加功能
public class ZombieTest {
    public static void main(String[] args) {
        NormalZombie normalZombie = new NormalZombie();
        FlagZombie flagZombie = new FlagZombie();
        HeadZombie headZombie = new HeadZombie();
        XxxZombie xxxZombie = new XxxZombie();

        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();

        flagZombie.display();
        flagZombie.move();
        flagZombie.attack();

        headZombie.display();
        headZombie.move();
        headZombie.attack();

        xxxZombie.display();
        xxxZombie.move();
        xxxZombie.attack();
    }
}

abstract class AbstractZombie {
    public abstract void display();

    public void attack() {
        System.out.println("咬");
    }

    public void move() {
        System.out.println("一步一步移动");
    }
}

class NormalZombie extends AbstractZombie {

    @Override
    public void display() {
        System.out.println("我是普通僵尸");
    }
}

class FlagZombie extends AbstractZombie {

    @Override
    public void display() {
        System.out.println("我是旗手僵尸");
    }
}

class HeadZombie extends AbstractZombie {

    @Override
    public void display() {
        System.out.println("我是大头僵尸");
    }

    @Override
    public void attack() {
        System.out.println("头撞");
    }
}

class XxxZombie extends AbstractZombie {

    @Override
    public void display() {
        System.out.println("我是Xxx僵尸");
    }

    @Override
    public void move() {
        System.out.println("Xxx的走");
    }
}