package com.example.main;

import com.example.beans.Vehicle;
import com.example.services.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example6 {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var vehicle1 = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from spring context is: " + vehicle1.getName());
        vehicle1.printHello();

        // Method with @PreDestroy will get called
        context.close();
    }
}
