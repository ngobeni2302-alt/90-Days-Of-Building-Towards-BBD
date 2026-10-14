import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PayrollTest {

    private PayrollSystem payroll;

    @BeforeEach
    void setUp() {
        payroll = new PayrollSystem();
    }

    @Test
    @DisplayName("PayrollSystem should add employees and protect roster via defensive copying")
    void testAddAndGetEmployees() {
        Employee dev = new Developer("Alice", "DEV-001", 5000.0, 1500.0);
        Employee manager = new Manager("Bob", "MGR-001", 8000.0, 3000.0);

        payroll.addEmployee(dev);
        payroll.addEmployee(manager);

        List<Employee> employees = payroll.getEmployees();
        assertEquals(2, employees.size());

        // Ensure defensive copying: clearing the returned list shouldn't affect internal company records
        employees.clear();
        assertEquals(2, payroll.getEmployees().size(), "Internal employee list should be protected via defensive copying");
    }

    @Test
    @DisplayName("addEmployee should throw an exception if a null employee is added")
    void testAddNullEmployeeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            payroll.addEmployee(null);
        }, "Adding a null employee should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("getTotalPayroll should polymorphically calculate and sum different salary structures")
    void testTotalPayroll() {
        // Developer: base 5000 + bonus 1500 = 6500
        Employee dev = new Developer("Alice", "DEV-001", 5000.0, 1500.0);

        // Manager: base 8000 + bonus 3000 = 11000
        Employee manager = new Manager("Bob", "MGR-001", 8000.0, 3000.0);

        // Intern: base stipend 3000 = 3000
        Employee intern = new Intern("Charlie", "INT-001", 3000.0);

        payroll.addEmployee(dev);
        payroll.addEmployee(manager);
        payroll.addEmployee(intern);

        // 6500 + 11000 + 3000 = 20500
        assertEquals(20500.0, payroll.getTotalPayroll(), 0.001);
    }

    @Test
    @DisplayName("findEmployee should locate the correct worker by employee ID and return null if missing")
    void testFindEmployee() {
        Employee dev = new Developer("Alice", "DEV-001", 5000.0, 1500.0);
        Employee intern = new Intern("Charlie", "INT-001", 3000.0);

        payroll.addEmployee(dev);
        payroll.addEmployee(intern);

        // Test finding existing employee
        Employee found = payroll.findEmployee("DEV-001");
        assertNotNull(found);
        assertEquals("Developer", found.getRole());
        assertEquals("Alice", found.getName());
        assertEquals(6500.0, found.calculateSalary(), 0.001);

        // Test searching for non-existent employee ID
        Employee missing = payroll.findEmployee("MISSING-999");
        assertNull(missing, "Searching for a non-existent ID should return null");
    }

    @Test
    @DisplayName("Verify individual subclass roles and calculation contracts")
    void testSubclassContracts() {
        Employee dev = new Developer("David", "DEV-002", 4000.0, 1000.0);
        Employee mgr = new Manager("Eve", "MGR-002", 7000.0, 2000.0);
        Employee intn = new Intern("Frank", "INT-002", 2500.0);

        assertEquals("Developer", dev.getRole());
        assertEquals(5000.0, dev.calculateSalary(), 0.001);

        assertEquals("Manager", mgr.getRole());
        assertEquals(9000.0, mgr.calculateSalary(), 0.001);

        assertEquals("Intern", intn.getRole());
        assertEquals(2500.0, intn.calculateSalary(), 0.001);
    }
}