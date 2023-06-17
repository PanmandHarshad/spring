package com.easybytes.easyschool.model;


import lombok.extern.slf4j.Slf4j;

/**
 * @Data annotation is provided by Lombok library which generates getter, setter,
 * equals(), hashCode(), toString() methods & Constructor at compile time.
 * This makes our code short and clean.
 */
public record Holiday(String day, String reason, Type type) {
    public enum Type {
        FESTIVAL, FEDERAL
    }
}
