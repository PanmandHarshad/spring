package com.example.services;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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

    @Bean(name = "AudiVehicle")
    Vehicle vehicle1() {
        var vehicle = new Vehicle();
        vehicle.setName("Audi 8");
        return vehicle;
    }

    @Bean(value = "MercedesVehicle")
    Vehicle vehicle2() {
        var vehicle = new Vehicle();
        vehicle.setName("Mercedes GLA");
        return vehicle;
    }

    /**
     * You can make one of them as primary by using @Primary annotation. Primary bean is
     * the one that spring will choose if it has multiple options, and you don't specify a name.
     * In other words, it is a default bean that Spring Context will consider in case of
     * confusion due to multiple beans present of same type.
     */
    @Primary
    @Bean("BMWVehicle")
    Vehicle vehicle3() {
        var vehicle = new Vehicle();
        vehicle.setName("BMW X7");
        return vehicle;
    }
}
