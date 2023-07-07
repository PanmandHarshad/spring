package com.easybytes.easyschool.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @Data annotation is provided by Lombok library which generates getter, setter,
 * equals(), hashCode(), toString() methods & Constructor at compile time.
 * This makes our code short and clean.
 */
@Data
@Entity
@Table(name = "holidays")
public class Holiday extends BaseEntity {
    @Id
    String day;
    String reason;
    @Enumerated(EnumType.STRING)
    Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }
}
