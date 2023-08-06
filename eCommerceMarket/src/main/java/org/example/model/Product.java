package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int productId;

    @NotBlank(message = "Name must not be blank")
    @jakarta.validation.constraints.Size(min = 3, message = "Name must be at least 3 characters long")
    String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brandId", nullable = false)
    Brand brand;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId", nullable = false)
    Category category;

    @NotBlank(message = "Price must not be blank")
    @DecimalMin(value = "0.01", message = "price must be greater that or equal to 0.01")
    BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "colorId", nullable = false)
    Color colorId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sizeId", nullable = false)
    ItemSize itemSizeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "inventoryId", nullable = false)
    Inventory inventory;

    @NotBlank(message = "SKU must not be blank")
    String sku;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sellerId", nullable = false)
    Seller sellerId;

    @LastModifiedDate
    LocalDateTime lastUpdated;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    List<Cart> carts = new ArrayList<>();

    @ManyToMany(mappedBy = "products")
    List<WishList> wishlists = new ArrayList<>();

}