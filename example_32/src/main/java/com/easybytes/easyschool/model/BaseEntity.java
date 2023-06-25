package com.easybytes.easyschool.model;

import java.time.LocalDateTime;

public record BaseEntity(
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime updatedAt,
        String updatedBy
) {
}
