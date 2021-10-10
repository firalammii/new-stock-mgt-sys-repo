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
    @NotBlank(message="field is required")
    private String firstName;

    @Column(nullable = false)
    @NotBlank(message="field is required")
    private String middleName;

    @Column(nullable = false)
    @NotBlank(message="field is required")
    private String lastName;

    @Column(nullable = false)
    @NotBlank(message="field is required")
    private String email;

    @Column(nullable = false)
    @NotBlank(message="field is required")
    private String phoneNumber;

    @Column(nullable = false)
    @NotBlank(message="field is required")
    private String itemsPurchased; //since it can be many it is separated by comma

    private LocalDate datePurchased = LocalDate.now();

}
