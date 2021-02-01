package com.edlison.design.v1.builder;

import com.edlison.design.v1.builder.builders.CarBuilder;
import com.edlison.design.v1.builder.builders.CarManualBuilder;
import com.edlison.design.v1.builder.cars.Car;
import com.edlison.design.v1.builder.cars.Manual;
import com.edlison.design.v1.builder.director.Director;

/**
 * BuilderTest
 * 客户端
 *
 * @Author Edlison
 * @Date 1/28/21 17:09
 */
public class BuilderTest {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder carBuilder = new CarBuilder();
        director.constructCityCar(carBuilder);
        Car car1 = carBuilder.getRes();

        director.constructSUV(carBuilder);
        Car car2 = carBuilder.getRes();

        System.out.println("car1: " + car1);
        System.out.println("car2: " + car2);

        CarManualBuilder carManualBuilder = new CarManualBuilder();
        director.constructSportsCar(carManualBuilder);
        Manual manual = carManualBuilder.getRes();

        System.out.println("manual: " + manual.print());
    }
}
