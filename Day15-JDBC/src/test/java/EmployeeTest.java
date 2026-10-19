import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

public class EmployeeTest {
    private EmployeeDAO dao;

    @BeforeEach
    public void setup() throws SQLException {
        dao = new EmployeeDAO();
        dao.createTable();
        // Clear all records before each test to ensure a clean state
        for (Employee e : dao.getAll()) {
            dao.delete(e.getId());
        }
    }

    @Test
    public void testAddAndFind() throws SQLException {
        Employee emp = new Employee(1, "Thabo", "Developer", 20000.0);
        dao.addEmployee(emp);

        Employee found = dao.findById(1);
        assertNotNull(found, "Employee should be found in the database");
        assertEquals(1, found.getId());
        assertEquals("Thabo", found.getName());
        assertEquals("Developer", found.getRole());
        assertEquals(20000.0, found.getSalary());
    }

    @Test
    public void testGetAllAndPayroll() throws SQLException {
        dao.addEmployee(new Employee(1, "Alice", "Developer", 25000.0));
        dao.addEmployee(new Employee(2, "Bob", "Manager", 45000.0));

        List<Employee> employees = dao.getAll();
        assertEquals(2, employees.size(), "Database should contain exactly 2 employees");

        double totalPayroll = dao.totalPayroll();
        assertEquals(70000.0, totalPayroll, 0.001, "Total payroll calculation should be accurate");
    }

    @Test
    public void testDelete() throws SQLException {
        dao.addEmployee(new Employee(1, "Charlie", "Intern", 10000.0));
        assertNotNull(dao.findById(1), "Employee should exist before deletion");

        dao.delete(1);
        assertNull(dao.findById(1), "Employee should no longer exist after deletion");
    }
}