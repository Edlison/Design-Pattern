package com.edlison.design.v1.builder.director;

import com.edlison.design.v1.builder.builders.Builder;
import com.edlison.design.v1.builder.cars.CarType;
import com.edlison.design.v1.builder.components.Engine;
import com.edlison.design.v1.builder.components.GPSNavigator;
import com.edlison.design.v1.builder.components.Transmission;
import com.edlison.design.v1.builder.components.TripComputer;

/**
 * Director
 * 主管控制生成器
 *
 * @Author Edlison
 * @Date 1/28/21 17:10
 */
public class Director {
    public void constructCityCar(Builder builder) {
        builder.setCarType(CarType.CITY_CAT);
        builder.setSeats(2);
        builder.setEngine(new Engine(2.0, 10));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(1.5, 20));
        builder.setTransmission(Transmission.MANUAL);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructSUV(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setSeats(2);
        builder.setEngine(new Engine(1.0, 50));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        // 没有TripComputer
        builder.setGPSNavigator(new GPSNavigator());
    }
}
