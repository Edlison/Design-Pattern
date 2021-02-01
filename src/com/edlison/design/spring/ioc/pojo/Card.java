package com.edlison.design.spring.ioc.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Card
 *
 * @Author Edlison
 * @Date 2/1/21 15:49
 */
@Component
public class Card {
    @Value("1801")
    private String ID;

    @Override
    public String toString() {
        return "Card{" +
                "ID='" + ID + '\'' +
                '}';
    }
}
