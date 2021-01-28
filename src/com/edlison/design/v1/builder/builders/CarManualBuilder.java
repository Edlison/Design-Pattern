package com.edlison.design.v1.builder.builders;

import com.edlison.design.v1.builder.cars.CarType;
import com.edlison.design.v1.builder.cars.Manual;
import com.edlison.design.v1.builder.components.Engine;
import com.edlison.design.v1.builder.components.GPSNavigator;
import com.edlison.design.v1.builder.components.Transmission;
import com.edlison.design.v1.builder.components.TripComputer;

/**
 * CarManualBuilder
 * 汽车手册生成器
 *
 * @Author Edlison
 * @Date 1/28/21 17:06
 */
public class CarManualBuilder implements Builder{
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override
    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Manual getRes() {
        return new Manual(this.type, this.seats, this.engine, this.transmission, this.tripComputer, this.gpsNavigator);
    }
}
