package com.example.services;

import com.example.interfaces.LogAspect;
import com.example.interfaces.Speaker;
import com.example.interfaces.Tyre;
import com.example.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class VehicleServices {
    private Logger logger = Logger.getLogger(VehicleServices.class.getName());
    @Autowired
    private Speaker speaker;
    private Tyre tyre;

    @LogAspect
    public String playMusic(boolean vehicleStarted, Song song) {
//        Instant start = Instant.now();
//        logger.info("Method execution start");

//        String music = null;
//        if (vehicleStarted) {
//            music = speaker.makeSound(song);
//        } else {
//            logger.log(Level.SEVERE, "Vehicle not started to perform the operation");
//        }

//        logger.info("Method execution end");
//        Instant finish = Instant.now();
//        long timeElapsed = Duration.between(start, finish).toMillis();
//        logger.info("Time took to execute the method : " + timeElapsed);

        return speaker.makeSound(song);
    }

    public String moveVehicle(boolean vehicleStarted) {
//        Instant start = Instant.now();
//        logger.info("Method execution start");

//        String status = null;
//        if (vehicleStarted) {
//            status = tyre.rotate();
//        } else {
//            logger.log(Level.SEVERE, "Vehicle not started to perform the operation");
//        }

//        logger.info("Method execution end");
//        Instant finish = Instant.now();
//        long timeElapsed = Duration.between(start, finish).toMillis();
//        logger.info("Time took to execute the method : " + timeElapsed);

        return tyre.rotate();
    }

    public String applyBreaks(boolean vehicleStarted) {
//        Instant start = Instant.now();
//        logger.info("Method execution start");

//        String status = null;
//        if (vehicleStarted) {
//            status = tyre.stop();
//        } else {
//            logger.log(Level.SEVERE, "Vehicle not started to perform the operation");
//        }

//        logger.info("Method execution end");
//        Instant finish = Instant.now();
//        long timeElapsed = Duration.between(start, finish).toMillis();
//        logger.info("Time took to execute the method : " + timeElapsed);

        return tyre.stop();
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Tyre getTyre() {
        return tyre;
    }

    @Autowired
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }


}
