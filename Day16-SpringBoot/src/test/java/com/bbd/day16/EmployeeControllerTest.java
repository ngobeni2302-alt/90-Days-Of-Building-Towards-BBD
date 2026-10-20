package com.bbd.springboot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
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

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        employeeRepository.deleteAll();
    }

    @Test
    public void testCreateAndGetEmployee() throws Exception {
        Employee employee = new Employee("Thabo", "Developer", 25000.0);

        // Test POST /employees
        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Thabo"));

        // Test GET /employees
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Thabo"));
    }

    @Test
    public void testTotalPayroll() throws Exception {
        employeeRepository.save(new Employee("Alice", "Developer", 20000.0));
        employeeRepository.save(new Employee("Bob", "Manager", 30000.0));

        // Test GET /employees/payroll
        mockMvc.perform(get("/employees/payroll"))
                .andExpect(status().isOk())
                .andExpect(content().string("50000.0"));
    }
}