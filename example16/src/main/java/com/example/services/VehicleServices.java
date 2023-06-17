package com.example.services;

import com.example.interfaces.Speaker;
import com.example.interfaces.Tyre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class VehicleServices {

    @Autowired
    private Speaker speaker;
    private Tyre tyre;

    public VehicleServices(){
        System.out.println("vehicleService bean is created");
    }

    public void playMusic() {
        String music = speaker.makeSound();
        System.out.println(music);
    }

    public void moveVehicle() {
        String status = tyre.rotate();
        System.out.println(status);
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
