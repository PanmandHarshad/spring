package com.easybytes.easyschool.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Data annotation is provided by Lombok library which generates getter, setter,
 * equals(), hashCode(), toString() methods & Constructor at compile time.
 * This makes our code short and clean.
 */
@Data
@MappedSuperclass
public class BaseEntity {

    LocalDateTime createdAt;
    String createdBy;
    LocalDateTime updatedAt;
    String updatedBy;


}
