package com.example.main;

import com.example.beans.Vehicle;
import com.example.services.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example5 {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Here we have 3 methods that returning the same bean type
        // while retrieving the bean from spring context we are not specifying the name of the bean
        // Here primary bean we be retrieved
        var vehicle1 = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from spring context is: " + vehicle1.getName());
        vehicle1.printHello();

    }
}
