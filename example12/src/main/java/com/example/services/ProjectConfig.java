package com.example.services;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Spring @Configuration annotation is part of the spring core framework.
 * Spring configuration indicates that the class has @Bean definition methods.
 * So spring container can process the class and generate Spring Beans to be used in the application.
 */
@Configuration
@ComponentScan(basePackages = "com.example.beans")
public class ProjectConfig {

    @Bean
    Vehicle vehicle1() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Audi");
        return vehicle;
    }

    @Bean
    @Primary
    Vehicle vehicle2() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Mercedes");
        return vehicle;
    }

    @Bean
    Vehicle vehicle3() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("BMW");
        return vehicle;
    }
}
