package com.store_keepers.stockmanagementsystem;

import com.store_keepers.stockmanagementsystem.repositories.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class EmployeeRepository_UT {

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setup() {
        given(employeeRepository.count())
                .willReturn(3L);
    }

    @Test
    public void shouldReturnTheCount(){
        Long count = employeeRepository.count();
        assertThat(count.equals(3L));
    }

}
