package com.store_keepers.stockmanagementsystem.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String middleName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private Long itemId;

    private String itemName;
    private int quantity;
    private double price;
    private int noOfVisit = 0;
    private LocalDate date = LocalDate.now();

}
