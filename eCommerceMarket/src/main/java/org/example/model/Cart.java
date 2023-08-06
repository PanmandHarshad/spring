package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cardId;

    @OneToOne
    @JoinColumn(name = "userProfileId", nullable = false, unique = true)
    UserProfile userProfileId;

    @ManyToMany
    @JoinTable(name = "cart_product",
            joinColumns = @JoinColumn(name = "cartId"),
            inverseJoinColumns = @JoinColumn(name = "productId"))
    List<Product> products = new ArrayList<>();

    @DecimalMin(value = "1", message = "There should be at least one product in cart")
    int quantity;


    LocalDateTime addedToCartDate;
}
