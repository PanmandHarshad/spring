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
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sellerId;

    @NotBlank
    String sellerName;

    @OneToMany(mappedBy = "seller")
    private List<Inventory> inventories = new ArrayList<>();

}
