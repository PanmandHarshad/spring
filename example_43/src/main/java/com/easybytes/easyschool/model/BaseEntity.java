package com.easybytes.easyschool.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * @Data annotation is provided by Lombok library which generates getter, setter,
 * equals(), hashCode(), toString() methods & Constructor at compile time.
 * This makes our code short and clean.
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    // Whenever update operation happens this field will not be considered
    // this field will not available in update query
    LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    // Whenever update operation happens this field will not be considered
    // this field will not available in update query
    String createdBy;

    @LastModifiedDate
    @Column(insertable = false)
    // Whenever insert operation happens this field will not be considered,
    // this field will not available in insert query
    LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    // Whenever insert operation happens this field will not be considered
    // this field will not available in insert query
    String updatedBy;
}
