package com.easybytes.easyschool.model;

/**
 * @Data annotation is provided by Lombok library which generates getter, setter,
 * equals(), hashCode(), toString() methods & Constructor at compile time.
 * This makes our code short and clean.
 */
public record Holiday(String day, String reason, Type type, BaseEntity baseEntity) {
    public enum Type {
        FESTIVAL, FEDERAL
    }
}
