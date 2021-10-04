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
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message="field is required")
    private String firstName;

    @Column(nullable = false)
    @NotBlank(message="field is required")
    private String lastName;

    @Column(nullable = false)
    @NotBlank(message="field is required")
    private String middleName;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private LocalDate employmentDate = LocalDate.now();

    @Column(nullable = false)
    @NotBlank(message="field is required")
    private String position;

    @Column(nullable = false)
    @NotBlank(message="field is required")
    private String email;

    @Column(nullable = false, unique = true)
    @NotBlank(message="field is required")
    private String phoneNumber;

    private String remark = "Active/Member"; // is case fired active or fired
    private boolean hasAccessToDB = Boolean.FALSE; //because few people has the access specially only storekeepers
}
