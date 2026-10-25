package com.bbd.day21;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// INTEGRATION TEST - full Spring context + real H2 + MockMvc - BBD deployment check
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper mapper;

    @Test
    public void testFullFlow() throws Exception {
        Employee emp = new Employee("Integration","QA",15000);
        String json = mapper.writeValueAsString(emp);

        // Create
        mockMvc.perform(post("/api/employees").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated());

        // Get all
        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").exists());
    }
}
