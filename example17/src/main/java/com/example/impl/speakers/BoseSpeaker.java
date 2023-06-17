package com.example.impl.speakers;

import com.example.interfaces.Speaker;
import com.example.model.Song;
import org.springframework.stereotype.Component;

@Component
public class BoseSpeaker implements Speaker {
    @Override
    public String makeSound(Song song) {
        return "Playing the song " + song.getTitle() + " by " +
                song.getSingerName() + " with BOSE speakers";
    }
}
