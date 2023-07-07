package com.easybytes.easyschool.model;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public record BaseEntity(
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime updatedAt,
        String updatedBy
) {
}
