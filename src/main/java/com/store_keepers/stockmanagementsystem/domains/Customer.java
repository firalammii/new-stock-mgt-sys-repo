package com.store_keepers.stockmanagementsystem.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    private int noOfItem;

    @Column(nullable = false)
    private Long itemId;

    @Column(nullable = false)
    private Double price;

    private Long sellerId;
    private String itemName;
    private LocalDate date = LocalDate.now();
    private int noOfVisit=0;

}
