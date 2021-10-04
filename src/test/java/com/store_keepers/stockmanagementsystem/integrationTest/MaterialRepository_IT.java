package com.store_keepers.stockmanagementsystem.integrationTest;

import com.store_keepers.stockmanagementsystem.domains.Materials;
import com.store_keepers.stockmanagementsystem.repositories.MaterialRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
public class MaterialRepository_IT {

    @Autowired
    private MaterialRepository materialRepository;


    @Test
    public void shouldCreateMaterialWithValidDetails(){
        //Given
        Materials materials = Materials.builder()
                .category("Drug")
                .cost(45.99)
                .dateBought(LocalDate.of(2019,9,12))
                .dateSold(LocalDate.of(2021,9,20))
                .expiryDate(LocalDate.of(2022,6,6))
                .name("Paracetamol")
                .No_inStore(45)
                .price(50.00)
                .productCompany("EPHARM")
                .productCountry("Ethiopia")
                .purchaser(2L)
                .soldBy(1L)
                .standard("ISO 9000/12")

                .build();
        
        //When
        Materials materials1 = materialRepository.save(materials);

        //Then

        assertThat(materials1.getProductCompany().equals(materials.getProductCompany()));
    }
}
