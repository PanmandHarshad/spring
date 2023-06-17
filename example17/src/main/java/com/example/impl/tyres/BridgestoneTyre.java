package com.example.impl.tyres;

import com.example.interfaces.Tyre;
import org.springframework.stereotype.Component;

@Component
public class BridgestoneTyre implements Tyre {
    @Override
    public String rotate() {
        return "Vehicle moving with the help of Bridgestone tyres";
    }

    @Override
    public String stop() {
        return "Vehicle stopped with the help of Bridgestone tyres";
    }
}
