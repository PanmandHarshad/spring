package com.example.beans;


import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private static String name;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Student.name = name;
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying Student bean");
    }
}
