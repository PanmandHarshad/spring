package com.example.impl.speakers;

import com.example.interfaces.Speaker;
import com.example.model.Song;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonySpeaker implements Speaker {
    @Override
    public String makeSound(Song song) {
        return "Playing the song " + song.getTitle() + " by " +
                song.getSingerName() + " with SONY speakers";
    }
}
