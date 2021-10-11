package com.store_keepers.stockmanagementsystem.domains;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //material properties
    private String itemName;
    private String itemCategory;
    private int noOfItem;

    //Seller property
    private String sellerFullName;

    //customer properties
    private String customerPhoneNumber;

    private String customerFullName;

    //additional details
    @Column(nullable = false)
    private Long customerId;

    private Double price;
    private LocalDate dateSold = LocalDate.now();

}
