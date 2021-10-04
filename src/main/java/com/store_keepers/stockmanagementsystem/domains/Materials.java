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

public class Materials {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message="field is required")
    private String category;

    @Column(nullable = false)
    @NotBlank(message="field is required")
    private String productCountry;

    private String productCompany;

    private String standard;

    @Column(nullable = false)
    private LocalDate dateSold;

    @Column(nullable = false)
    private LocalDate expiryDate;

    @Column(nullable = false)
    private LocalDate dateBought;

    @Column(nullable = false)
    @NotBlank(message="field is required")
    private String name;

    @Column(nullable = false)
    @NotNull(message="field is required")
    private int No_inStore;

    @Column(nullable = false)
    @NotNull(message="field is required")
    private double cost;

    @Column(nullable = false)
    @NotNull(message="field is required")
    private double price;

    @Column(nullable = false)
    @NotNull(message="field is required")
    private Long soldBy;

    @Column(nullable = false)
    @NotNull(message="field is required")
    private Long purchaser;
}
