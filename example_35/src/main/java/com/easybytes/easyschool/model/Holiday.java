package com.easybytes.easyschool.model;

import jakarta.persistence.*;

/**
 * @Data annotation is provided by Lombok library which generates getter, setter,
 * equals(), hashCode(), toString() methods & Constructor at compile time.
 * This makes our code short and clean.
 */
@Entity
@Table(name = "holidays")
public record Holiday(
        @Id
        String day,
        String reason,
        @Enumerated(EnumType.STRING)
        Type type,
        BaseEntity baseEntity) {
    public enum Type {
        FESTIVAL, FEDERAL
    }
}
