package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"userId"}))
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String wishListId;

    @NotBlank(message = "User must not be blank")
    User user;

    @ManyToMany
    @JoinTable(
            name = "wishlist_product",
            joinColumns = @JoinColumn(name = "wishlist_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    List<Product> products = new ArrayList<>();
}
