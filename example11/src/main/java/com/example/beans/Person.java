package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    /**
     * If you have only one constructor in java class then @Autowired annotation is optional.
     * It is recommended to use @Autowired
     *
     * @param vehicle
     */
    @Autowired
    public Person(Vehicle vehicle) {
        System.out.println("Person bean created by Spring");
        this.vehicle = vehicle;
    }

    private String name = "Lucy";

    /**
     * The @Autowired annotation marks on a field, constructor, Setter method
     * is used to auto-wire the beans that is ‘injecting beans'(Objects) at runtime
     * by Spring Dependency Injection mechanism
     */
    //@Autowired
    private final Vehicle vehicle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * When you declare this.vehicle as final then setter method will not work
     * @param vehicle
     */
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }


}
