package com.example.beans;

import com.example.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("vehicleBean")
public class Vehicle {

    private String name = "Toyota";
    private final VehicleServices vehicleServices;

    @Autowired
    public Vehicle(VehicleServices vehicleServices) {
        this.vehicleServices = vehicleServices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleServices getVehicleService() {
        return vehicleServices;
    }

    public void printHello() {
        System.out.println("Printing hello from component Vehicle bean");
    }

    @Override
    public String toString() {
        return "Vehicle name is " + name;
    }
}
