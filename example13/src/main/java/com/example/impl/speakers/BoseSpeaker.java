package com.example.impl.speakers;

import com.example.interfaces.Speaker;
import org.springframework.stereotype.Component;

@Component
public class BoseSpeaker implements Speaker {
    @Override
    public String makeSound() {
        return "Sound from BOSE speaker";
    }
}
