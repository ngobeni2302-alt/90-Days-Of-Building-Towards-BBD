import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyTest {

    private Company company;

    @BeforeEach
    void setUp() {
        company = new Company();
    }

    @Test
    @DisplayName("addEmployee should successfully add workers and throw exception on duplicate ID")
    void testAddEmployeeAndDuplicates() {
        Employee dev1 = new Developer("Alice", "101", 5000.0, 1500.0);
        Employee devDuplicate = new Developer("Alicia", "101", 6000.0, 2000.0);

        company.addEmployee(dev1);
        assertEquals(1, company.getAll().size());

        // Adding an employee with an already existing ID must fail
        assertThrows(IllegalArgumentException.class, () -> {
            company.addEmployee(devDuplicate);
        }, "Adding a duplicate employee ID should throw IllegalArgumentException");

        assertEquals(1, company.getAll().size(), "Company list size should remain 1 after duplicate attempt");
    }

    @Test
    @DisplayName("findById should retrieve employee instantly using HashMap O(1) lookup")
    void testFindById() {
        Employee dev = new Developer("Alice", "101", 5000.0, 1500.0);
        Employee manager = new Manager("Bob", "102", 8000.0, 3000.0);

        company.addEmployee(dev);
        company.addEmployee(manager);

        Employee found = company.findById("102");
        assertNotNull(found);
        assertEquals("Bob", found.getName());
        assertEquals("Manager", found.getRole());

        // Test non-existent ID
        assertNull(company.findById("999"), "Searching for non-existent ID should return null");
    }

    @Test
    @DisplayName("findByRole should correctly filter employees by their job role")
    void testFindByRole() {
        company.addEmployee(new Developer("Alice", "101", 5000.0, 1000.0));
        company.addEmployee(new Developer("Charlie", "102", 5500.0, 1200.0));
        company.addEmployee(new Manager("Bob", "103", 8000.0, 3000.0));
        company.addEmployee(new Intern("Dave", "104", 3000.0));

        List<Employee> developers = company.findByRole("Developer");
        assertEquals(2, developers.size());
        for (Employee e : developers) {
            assertEquals("Developer", e.getRole());
        }

        List<Employee> managers = company.findByRole("Manager");
        assertEquals(1, managers.size());
        assertEquals("Bob", managers.get(0).getName());

        List<Employee> unknownRole = company.findByRole("Director");
        assertTrue(unknownRole.isEmpty(), "Filtering by a non-existent role should return an empty list");
    }

    @Test
    @DisplayName("totalPayroll should sum up all calculated salaries correctly")
    void testTotalPayroll() {
        company.addEmployee(new Developer("Alice", "101", 5000.0, 1000.0)); // 6000
        company.addEmployee(new Manager("Bob", "102", 8000.0, 2000.0));    // 10000
        company.addEmployee(new Intern("Charlie", "103", 3000.0));          // 3000

        assertEquals(19000.0, company.totalPayroll(), 0.001);
    }

    @Test
    @DisplayName("removeEmployee should cleanly remove workers from both map and list")
    void testRemoveEmployee() {
        Employee dev = new Developer("Alice", "101", 5000.0, 1500.0);
        company.addEmployee(dev);

        assertNotNull(company.findById("101"));
        assertEquals(1, company.getAll().size());

        company.removeEmployee("101");

        assertNull(company.findById("101"), "Employee should be removed from the HashMap");
        assertTrue(company.getAll().isEmpty(), "Employee list should be empty after removal");
    }

    @Test
    @DisplayName("getAll should protect internal records via defensive copying")
    void testDefensiveCopying() {
        company.addEmployee(new Developer("Alice", "101", 5000.0, 1500.0));

        List<Employee> externalList = company.getAll();
        assertEquals(1, externalList.size());

        // Modifying the returned list shouldn't corrupt the company's internal state
        externalList.clear();
        assertEquals(1, company.getAll().size(), "Internal company employee list should be protected via defensive copying");
    }
}