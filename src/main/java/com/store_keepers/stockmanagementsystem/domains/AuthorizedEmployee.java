package com.store_keepers.stockmanagementsystem.domains;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class AuthorizedEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String role;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Long companyId;

}
