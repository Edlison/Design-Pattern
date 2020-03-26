package com.edlison.design.observer;

import java.util.ArrayList;
import java.util.List;

// 观察者模式
public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new Subject();
        TaskA taskA = new TaskA();
        subject.addObserver(taskA);
        TaskB taskB = new TaskB();
        subject.addObserver(taskB);
        taskA.update("stage 1");
        taskB.update("stage 1");

        subject.notifyObserver("stage 2");

        subject.removeObserver(taskB);
        subject.notifyObserver("stage 3 and taskB has been removed");
    }
}

class Subject {
    // container
    private List<Observer> container = new ArrayList<>();

    // add
    public void addObserver(Observer observer) {
        container.add(observer);
    }

    // remove
    public void removeObserver(Observer observer) {
        container.remove(observer);
    }

    public void notifyObserver(Object o) {
        for (Observer each : container) {
            each.update(o);
        }
    }
}

interface Observer {
    void update(Object o);
}

class TaskA implements Observer {

    @Override
    public void update(Object o) {
        System.out.println("TaskA received: " + o);
    }
}

class TaskB implements Observer {

    @Override
    public void update(Object o) {
        System.out.println("TaskB received: " + o);
    }
}

// 应用场景
// 当更改一个对象的状态可能需要更改其他对象，并且实际的对象集事先未知或动态更改时，使用观察者模式

// 优点
// 1. 符合开闭原则
// 2. 可以在运行时建立对象之间的关系