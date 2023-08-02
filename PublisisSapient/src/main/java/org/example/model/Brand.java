package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int brandId;

    @NotBlank(message = "Brand name must not be blank")
    @Size(min = 5, message = "Brand name must be at least 5 char long")
    String brandName;

}
