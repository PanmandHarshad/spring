package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int inventoryId;

    @DecimalMin(value = "0")
    int quantity;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    Product product;

    @ManyToOne
    @JoinColumn(name = "sellerID", nullable = false)
    Seller seller;

    @LastModifiedDate
    LocalDateTime lastUpdated;

    @OneToMany(mappedBy = "inventory")
    private List<Product> products = new ArrayList<>();
}