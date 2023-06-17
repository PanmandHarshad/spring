package com.example.main;

import com.example.beans.Vehicle;
import com.example.services.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Honda city");
        System.out.println("Vehicle name from non-spring context is: " + vehicle.getName());

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle bean = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from spring context is: " + bean.getName());

        String hello = context.getBean(String.class);
        System.out.println("String from spring context is: " + hello);

        Double number = context.getBean(Double.class);
        System.out.println("Integer value from spring context is: " + number);
    }
}
