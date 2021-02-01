package com.edlison.design.spring.ioc.pojo;

/**
 * Address
 *
 * @Author Edlison
 * @Date 2/1/21 10:34
 */
public class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
