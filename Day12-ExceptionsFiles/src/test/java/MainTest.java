import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class MainTest {

    @Test
    public void testDuplicateCheckedException() {
        Company c = new Company();
        try {
            c.addEmployee(new Developer("A", "1", 20000.0, 0));

            assertThrows(DuplicateIdException.class, () -> {
                c.addEmployee(new Developer("B", "1", 20000.0, 0));
            }, "Adding a duplicate ID should throw checked DuplicateIdException");

        } catch (DuplicateIdException e) {
            fail("First insertion should not throw an exception");
        }
    }

    @Test
    public void testNotFoundUnchecked() {
        Company c = new Company();

        assertThrows(EmployeeNotFoundException.class, () -> {
            c.findById("999");
        }, "Searching for a non-existent ID should throw EmployeeNotFoundException");
    }

    @Test
    public void testSaveAndLoad() throws Exception {
        Company c = new Company();
        c.addEmployee(new Developer("Thabo", "1", 20000.0, 1500.0));
        c.addEmployee(new Manager("Sarah", "2", 30000.0, 5000.0));

        String filename = "test_employees.txt";
        File testFile = new File(filename);

        try {
            FileStorage.saveToFile(c, filename);

            Company loaded = FileStorage.loadFromFile(filename);

            assertEquals(2, loaded.size(), "Loaded company should have exactly 2 employees");
            assertEquals(56500.0, loaded.totalPayroll(), 0.001, "Total payroll should match after file serialization round-trip");

        } finally {
            // Guaranteed to delete the file even if assertions fail
            if (testFile.exists()) {
                testFile.delete();
            }
        }
    }
}