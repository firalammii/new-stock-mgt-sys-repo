package com.store_keepers.stockmanagementsystem.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotBlank(message="field is required")
    private String category;

    @Column(nullable = false)
    @NotBlank(message="field is required")
    private String productCountry;

    @Column(nullable = false)
    @NotBlank(message="field is required")
    private String productCompany;

    @Column(nullable = false)
    @NotBlank(message="field is required")
    private String itemName;

    private LocalDate dateBought=LocalDate.now();

    @Column(nullable = false)
    private String itemTagNum;

    @Column(nullable = false)
    @NotNull(message="field is required")
    private int noOfItem;

    @Column(nullable = false)
    @NotNull(message="field is required")
    private double cost;

    @Column(nullable = false)
    @NotNull(message="field is required")
    private double minSellingPrice;

    @Column(nullable = false)
    @NotNull(message="field is required")
    private Long purchaser;

    private String standard;
}
