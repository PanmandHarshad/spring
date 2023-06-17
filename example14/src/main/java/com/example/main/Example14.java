package com.example.main;

import com.example.config.ProjectConfig;
import com.example.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Example14 {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleServices vehicleServices1 = context.getBean(VehicleServices.class);
        VehicleServices vehicleServices2 = context.getBean("vehicleServices", VehicleServices.class);

        System.out.println("Hashcode of vehicleService1: " + vehicleServices1.hashCode());
        System.out.println("Hashcode of vehicleService2: " + vehicleServices2.hashCode());

        if (vehicleServices1 == vehicleServices2) {
            System.out.println("vehicleServices bean is singleton bean");
        }
    }
}
