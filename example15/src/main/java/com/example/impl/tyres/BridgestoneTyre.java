package com.example.impl.tyres;

import com.example.interfaces.Tyre;
import org.springframework.stereotype.Component;

@Component
public class BridgestoneTyre implements Tyre {
    @Override
    public String rotate() {
        return "Vehicle moving with Bridgestone tyres";
    }
}
