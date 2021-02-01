package com.edlison.design.spring.ioc.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Bike
 *
 * @Author Edlison
 * @Date 2/1/21 16:18
 */
@Component
public class Bike {
    @Value("Phenix")
    private String brand;

    @Override
    public String toString() {
        return "Bike{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
