package com.bbd.day18;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class EmployeeServiceTest {
    @Autowired EmployeeService service;
    @Test
    public void testDTOAndBusinessRule() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setName("Thabo"); dto.setRole("Developer"); dto.setSalary(25000);
        // dept null, service should set to Engineering
        EmployeeDTO saved = service.create(dto);
        assertEquals("Engineering", saved.getDepartment());
        assertNotNull(saved.getSalaryGrade());
        // B grade for 25000? Actually <30000 = C, check mapper
        assertEquals("C", saved.getSalaryGrade());
    }
}
