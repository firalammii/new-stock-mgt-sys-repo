package com.store_keepers.stockmanagementsystem.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data

public class Material {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String productCountry;

    @Column(nullable = false)
    private String productCompany;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private int noOfItem;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    private double minSellingPrice;

    @Column(nullable = false)
    private Long purchaser;

    private String standard;
    private LocalDate dateBought=LocalDate.now();
}
