package com.edlison.design.v1.builder.components;

import com.edlison.design.v1.builder.cars.Car;

/**
 * TripComputer
 * 产品特征4
 *
 * @Author Edlison
 * @Date 1/28/21 17:10
 */
public class TripComputer {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void showFuel() {
        System.out.println("car.getFuel() = " + this.car.getFuel());
    }

    public void showStatus() {
        System.out.println("car.getEngine().isStarted() = " + this.car.getEngine().isStarted());
    }
}
