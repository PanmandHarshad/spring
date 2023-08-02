package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"userId"}))
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cardId;

    @NotBlank(message = "User must not be blank")
    User userId;

    @ManyToMany
    @JoinTable(name = "cart_product",
            joinColumns = @JoinColumn(name = "cartId"),
            inverseJoinColumns = @JoinColumn(name = "productId"))
    List<Product> products = new ArrayList<>();

    @DecimalMin(value = "1", message = "There should be at least one product in cart")
    int quantity;


    LocalDateTime addedToCartDate;
}
