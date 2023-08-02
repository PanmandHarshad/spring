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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    int categoryId;

    @NotBlank(message = "Category type must not be blank")
    @Size(min = 3, message = "Category type must be at least 3 char long")
    String categoryType; // pant, socks
}
