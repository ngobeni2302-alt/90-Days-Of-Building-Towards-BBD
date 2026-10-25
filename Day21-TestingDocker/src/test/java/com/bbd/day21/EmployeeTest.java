package com.bbd.day21;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// UNIT TEST - no Spring needed, just plain JUnit - fast
public class EmployeeTest {
    @Test
    public void testBonusCalculation(){
        Employee emp = new Employee("Thabo","Dev",20000);
        assertEquals(2000, emp.calculateBonus(), 0.01);
    }
    @Test
    public void testGettersSetters(){
        Employee emp = new Employee();
        emp.setName("Lucky");
        emp.setSalary(50000);
        assertEquals("Lucky", emp.getName());
        assertEquals(50000, emp.getSalary());
    }
}
