package com.example.impl.speakers;

import com.example.interfaces.Speaker;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonySpeaker implements Speaker {
    @Override
    public String makeSound() {
        return "Sound from SONY speakers";
    }
}
