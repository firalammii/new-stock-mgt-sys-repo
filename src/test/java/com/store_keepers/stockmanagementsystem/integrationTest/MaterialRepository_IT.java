package com.store_keepers.stockmanagementsystem.integrationTest;

import com.store_keepers.stockmanagementsystem.domains.Material;
import com.store_keepers.stockmanagementsystem.services.MaterialService;
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
    private MaterialService materialService;

    @Test
    public void shouldCreateMaterialWithValidDetails(){
        //Given
        Material material = Material.builder()
                .category("Drug")
                .cost(45.99)
                .itemName("Paracetamol")
                .noOfItem(45)
                .minSellingPrice(50.00)
                .productCompany("EPHARM")
                .productCountry("Ethiopia")
                .purchaser(2L)
                .standard("ISO 9000/12")
                .build();

        //When
        Material material1 = materialService.addMaterial(material);

        //Then

        assertThat(material1.getProductCompany().equals(material.getProductCompany()));
    }
}
