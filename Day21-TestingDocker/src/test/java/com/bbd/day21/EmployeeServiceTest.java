package com.bbd.day21;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// MOCKITO TEST - mock repository, test service logic only - BBD interview standard
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock EmployeeRepository repo;
    @InjectMocks EmployeeService service;

    @Test
    public void testCreateValid(){
        Employee emp = new Employee("Thabo","Dev",20000);
        when(repo.save(any())).thenReturn(emp);
        Employee saved = service.create(emp);
        assertEquals("Thabo", saved.getName());
        verify(repo, times(1)).save(emp);
    }

    @Test
    public void testCreateInvalidSalaryThrows(){
        Employee emp = new Employee("Thabo","Dev",-100);
        assertThrows(IllegalArgumentException.class, () -> service.create(emp));
    }

    @Test
    public void testGetByIdNotFound(){
        when(repo.findById(99L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.getById(99L));
    }

    @Test
    public void testTotalPayroll(){
        when(repo.findAll()).thenReturn(List.of(
            new Employee("A","Dev",20000),
            new Employee("B","Dev",30000)
        ));
        assertEquals(50000, service.totalPayroll());
    }
}
