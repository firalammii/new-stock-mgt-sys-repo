package com.store_keepers.stockmanagementsystem.integrationTest;

import com.store_keepers.stockmanagementsystem.domains.Employee;
import com.store_keepers.stockmanagementsystem.repositories.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class EmployeeRepository_IT {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void shouldReturnValidEmployeeDetails(){

        //Given
        Employee employee = Employee.builder()
                .firstName("Alemayew")
                .middleName("Bogale")
                .lastName("Ayenachew")
                .birthDate(LocalDate.of(1990,8,30))
                .employmentDate(LocalDate.of(2020,9,29))
                .phoneNumber("0987654332")
                .email("kungfu@go.com")
                .position("cleaner")
                .build();


        //when

        Employee employee1 = employeeRepository.save(employee);

        //then
        assertThat(employee1.getPhoneNumber().equals(employee.getPhoneNumber()));
    }
}
