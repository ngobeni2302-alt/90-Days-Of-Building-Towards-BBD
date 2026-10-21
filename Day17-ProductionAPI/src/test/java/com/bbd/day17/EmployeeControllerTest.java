package com.bbd.day17;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;

    @Test
    public void testCreateAndGet() throws Exception {
        Employee emp = new Employee("Thabo", "Developer", 21500);
        String json = objectMapper.writeValueAsString(emp);

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Thabo"));

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk());
    }

    @Test
    public void testValidationFails() throws Exception {
        Employee invalid = new Employee("", "", -100);
        String json = objectMapper.writeValueAsString(invalid);

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testNotFound() throws Exception {
        mockMvc.perform(get("/employees/9999"))
                .andExpect(status().isNotFound());
    }
}
