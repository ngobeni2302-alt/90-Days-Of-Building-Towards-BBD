import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class MainTest {

    @Test
    public void testDuplicateCheckedException() {
        Company c = new Company();
        try {
            c.addEmployee(new Developer("A", 1, 20000.0, 0));

            // Attempting to add an employee with the same ID should throw DuplicateIdException
            assertThrows(DuplicateIdException.class, () -> {
                c.addEmployee(new Developer("B", 1, 20000.0, 0));
            }, "Adding a duplicate ID should throw checked DuplicateIdException");

        } catch (DuplicateIdException e) {
            fail("First insertion should not throw an exception");
        }
    }

    @Test
    public void testNotFoundUnchecked() {
        Company c = new Company();

        // Searching for an ID that doesn't exist should throw unchecked EmployeeNotFoundException
        assertThrows(EmployeeNotFoundException.class, () -> {
            c.findById(999);
        }, "Searching for a non-existent ID should throw EmployeeNotFoundException");
    }

    @Test
    public void testSaveAndLoad() throws Exception {
        Company c = new Company();
        c.addEmployee(new Developer("Thabo", 1, 20000.0, 10)); // 20000 + (10 * 150) = 21500
        c.addEmployee(new Manager("Sarah", 2, 30000.0, 5000.0));   // 30000 + 5000 = 35000
        // Total expected payroll = 21500 + 35000 = 56500

        String filename = "test_employees.txt";

        // Save to file
        FileStorage.saveToFile(c, filename);

        // Load back from file
        Company loaded = FileStorage.loadFromFile(filename);

        assertEquals(2, loaded.size(), "Loaded company should have exactly 2 employees");
        assertEquals(56500.0, loaded.totalPayroll(), 0.001, "Total payroll should match after file serialization round-trip");

        // Clean up test file
        File testFile = new File(filename);
        if (testFile.exists()) {
            testFile.delete();
        }
    }
}