package com.edlison.design.v1.builder.cars;

import com.edlison.design.v1.builder.components.Engine;
import com.edlison.design.v1.builder.components.GPSNavigator;
import com.edlison.design.v1.builder.components.Transmission;
import com.edlison.design.v1.builder.components.TripComputer;

/**
 * Manual
 * 手册产品
 *
 * @Author Edlison
 * @Date 1/28/21 17:09
 */
public class Manual {
    private final CarType type;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;

    public Manual(CarType type, int seats, Engine engine, Transmission transmission, TripComputer tripComputer, GPSNavigator gpsNavigator) {
        this.type = type;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        this.gpsNavigator = gpsNavigator;
    }

    public String print() {
        String info = "";
        info += "Type of Car: " + type + '\n';
        info += "Seats num: " + seats + '\n';
        info += "Engine Volume: " + engine + '\n';
        info += "Transmission: " + transmission + '\n';

        if (this.tripComputer != null) {
            info += "Trip Computer: Functional\n";
        } else {
            info += "Trip Computer: N/A\n";
        }

        if (this.gpsNavigator != null) {
            info += "GPS Navigator: Functional\n";
        } else {
            info += "GPS Navigator: N/A\n";
        }

        return info;
    }
}
