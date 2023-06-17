package com.example.main;

import com.example.config.ProjectConfig;
import com.example.model.Song;
import com.example.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Example17 {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var vehicleServices = context.getBean(VehicleServices.class);
        System.out.println(vehicleServices.getClass());

        Song song = new Song();
        song.setTitle("Blank Space");
        song.setSingerName("Taylor Swift");

        boolean vehicleStarted = true;

//        vehicleServices.moveVehicle(vehicleStarted);
        vehicleServices.playMusic(vehicleStarted, song);
//        vehicleServices.applyBreaks(vehicleStarted);
    }
}
