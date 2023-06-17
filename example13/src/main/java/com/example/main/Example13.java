package com.example.main;

import com.example.beans.Person;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Example13 {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person = context.getBean(Person.class);

        System.out.println("Person name from Spring Context is: " + person.getName());
        System.out.println("Vehicle that person own is: " + person.getVehicle());
        person.getVehicle().getVehicleService().playMusic();
        person.getVehicle().getVehicleService().moveVehicle();
    }
}
