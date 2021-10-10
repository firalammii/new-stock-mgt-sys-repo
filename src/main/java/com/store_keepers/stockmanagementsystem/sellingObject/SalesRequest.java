package com.store_keepers.stockmanagementsystem.sellingObject;

import lombok.Data;

import javax.persistence.*;

import java.time.LocalDate;

@Data
@Entity
public class SalesRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long materialId;

    private Long soldBy;

    private double cost;

    private double price;
    private int noOfItemsSold;
    private Long customerId;
    private LocalDate dateSold = LocalDate.now();
}
