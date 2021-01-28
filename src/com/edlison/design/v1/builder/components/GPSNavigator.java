package com.edlison.design.v1.builder.components;

/**
 * GPSNavigator
 * 产品特征2
 *
 * @Author Edlison
 * @Date 1/28/21 17:10
 */
public class GPSNavigator {
    private String route;

    public GPSNavigator() {
        this.route = "auto gen";
    }

    public GPSNavigator(String manualRoute) {
        this.route = manualRoute;
    }

    public String getRoute() {
        return route;
    }
}
