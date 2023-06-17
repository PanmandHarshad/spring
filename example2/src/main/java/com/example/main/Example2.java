package com.example.main;

import com.example.beans.Vehicle;
import com.example.services.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2 {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        // As we have 3 methods in ProjectConfig class that returning Vehicle as Bean type
        // Spring is not able to decide which bean to retrieve, and
        // it throws NoUniqueBeanDefinitionException exception
        // To fix this we need pass method name as first argument.
        // Be default, Spring will consider method name as bean name in spring context
        //Vehicle bean = context.getBean(Vehicle.class);

        var vehicle1 = context.getBean("vehicle1", Vehicle.class);
        System.out.println("Vehicle name from spring context is: " + vehicle1.getName());


        var vehicle2 = context.getBean("vehicle2", Vehicle.class);
        System.out.println("Vehicle name from spring context is: " + vehicle2.getName());

        var vehicle3 = context.getBean("vehicle3", Vehicle.class);
        System.out.println("Vehicle name from spring context is: " + vehicle3.getName());
    }
}
