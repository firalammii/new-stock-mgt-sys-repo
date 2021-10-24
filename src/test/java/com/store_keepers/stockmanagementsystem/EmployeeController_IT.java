package com.store_keepers.stockmanagementsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class EmployeeController_IT {

    private final String ENDPOINT = "/employee/add";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldAddEmployeeWithValidInformation() throws Exception {
        String data = "{\n" +
                "    \"firstName\": \"sew\",\n" +
                "    \"lastName\": \"alew\",\n" +
                "    \"middleName\": \"new\",\n" +
                "    \"birthDate\": \"1990-02-03\",\n" +
                "    \"employmentDate\": \"2015-08-09\",\n" +
                "    \"position\": \"security\",\n" +
                "    \"email\": \"sth@sth.com\",\n" +
                "    \"phoneNumber\": \"09445667717\"\n" +
                "}";
        mockMvc.perform(
                        post(ENDPOINT)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(data)
                )
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().json("{\"id\":1,\"firstName\":\"sew\",\"lastName\":\"alew\",\"middleName\":\"new\",\"birthDate\":\"1990-02-03\",\"employmentDate\":\"2015-08-09\",\"position\":\"security\",\"email\":\"sth@sth.com\",\"phoneNumber\":\"09445667717\",\"remark\":\"Active/Member\",\"hasAccessToDB\":false}"))
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

}

