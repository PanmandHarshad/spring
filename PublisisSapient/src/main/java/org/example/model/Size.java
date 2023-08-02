package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Entity
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sizeId;

    @NotBlank(message = "Size type must not be blank")
    @JoinColumn(name = "sizeTypeId", nullable = false)
    SizeType sizeType;

    String chestSize;
    String waistSize;

}
