package com.edlison.design.v0.strategy.v2;

// 策略模式
public class ZombieTest {
    public static void main(String[] args) {
        NormalZombie normalZombie = new NormalZombie();
        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();

        System.out.println("更新技能");
        normalZombie.setAttackable(new HitAttack());
        normalZombie.attack();
    }
}

interface Moveable {
    void move();
}

interface Attackable {
    void attack();
}

abstract class Zombie {

    Moveable moveable;
    Attackable attackable;

    public Zombie() {
        this.moveable = new StepMove();
        this.attackable = new BiteAttack();
    }

    public Zombie(Moveable moveable, Attackable attackable) {
        this.moveable = moveable;
        this.attackable = attackable;
    }

    abstract public void display();
    public void move() {
        moveable.move();
    }
    public void attack() {
        attackable.attack();
    }

    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }

    public Attackable getAttackable() {
        return attackable;
    }

    public void setAttackable(Attackable attackable) {
        this.attackable = attackable;
    }
}

class BiteAttack implements Attackable {

    @Override
    public void attack() {
        System.out.println("攻击：咬");
    }
}

class HitAttack implements Attackable {

    @Override
    public void attack() {
        System.out.println("攻击：撞");
    }
}

class StepMove implements Moveable {

    @Override
    public void move() {
        System.out.println("移动：一步一步");
    }
}

class NormalZombie extends Zombie {

    public NormalZombie() {
        super();
    }

    public NormalZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("我是普通僵尸");
    }

}

class FlagZombie extends Zombie {

    public FlagZombie() {
        super();
    }

    public FlagZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("我是旗手僵尸");
    }
}

// 模式定义
// 定义了算法族，分别封装起来，让他们之间可以相互替换，此模式的变化独立于算法的使用者