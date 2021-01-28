package com.edlison.design.v1.builder.builders;

import com.edlison.design.v1.builder.cars.CarType;
import com.edlison.design.v1.builder.components.Engine;
import com.edlison.design.v1.builder.components.GPSNavigator;
import com.edlison.design.v1.builder.components.Transmission;
import com.edlison.design.v1.builder.components.TripComputer;

/**
 * Builder
 * 通用的生成器接口
 *
 * @Author Edlison
 * @Date 1/28/21 17:05
 */
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
