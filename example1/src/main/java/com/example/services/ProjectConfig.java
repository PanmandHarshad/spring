package com.example.services;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring @Configuration annotation is part of the spring core framework.
 * Spring configuration indicates that the class has @Bean definition methods.
 * So spring container can process the class and generate Spring Beans to be used in the application.
 */
@Configuration
public class ProjectConfig {

    /**
     * @Bean annotation, which lets spring know that it will need to call this method
     * when it initializes this context and adds returned value to context.
     */

    /**
     * Method name usually follow verb notations.
     * But for methods which we will use to create beans, can use noun as names.
     * This will be a good practice as method name will become bean names as well in the context.
     */
    @Bean
    Vehicle vehicle() {
        var vehicle = new Vehicle();
        vehicle.setName("Audi 8");
        return vehicle;
    }

    @Bean
    String hello() {
        return "Hello world";
    }

    @Bean
    Integer number() {
        return 10;
    }
}
