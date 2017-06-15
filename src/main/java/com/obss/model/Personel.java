package com.obss.model;

import com.obss.model.city.City;
import com.obss.model.route.type.RouteType;

/**
 * Created by Hasan on 27.09.2016.
 */
public class Personel {

    private int id;
    private String routeName;
    private City city;
    private int cityId;
    private RouteType routeType;
    private int routeTypeId;
    private double totalDuration;
    private double peronNo;
    private double vehicleType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public int getRouteTypeId() {
        return routeTypeId;
    }

    public void setRouteTypeId(int routeTypeId) {
        this.routeTypeId = routeTypeId;
    }

    public double getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(double totalDuration) {
        this.totalDuration = totalDuration;
    }

    public double getPeronNo() {
        return peronNo;
    }

    public void setPeronNo(double peronNo) {
        this.peronNo = peronNo;
    }

    public double getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(double vehicleType) {
        this.vehicleType = vehicleType;
    }
}
