package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Entity
public class SizeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sizeTypeId;

    @NotBlank(message = "Size type name must not blank")
    @Column(nullable = false)
    String sizeTypeName; //Small, large, medium
    String description;
}
