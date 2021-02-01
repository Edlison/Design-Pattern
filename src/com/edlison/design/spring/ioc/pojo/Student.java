package com.edlison.design.spring.ioc.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Student
 *
 * @Author Edlison
 * @Date 2/1/21 15:32
 */
@Component
public class Student {

    @Value("edlison")
    private String name;

    @Value("#{card}")
    private Card card;

    @Autowired
    private Bike bike;

    public String getName() {
        return name;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", card=" + card +
                ", bike=" + bike +
                '}';
    }
}
