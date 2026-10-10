import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    // 1. Constructor & Getter Tests
    @Test
    @DisplayName("Valid student should be created successfully and getters should return correct values")
    void testValidStudentCreation() {
        Student student = new Student("Alice", 20, 85.0);
        assertEquals("Alice", student.getName());
        assertEquals(20, student.getAge());
        assertEquals(85.0, student.getMarks());
    }

    // 2. Defensive Validation Tests (Name)
    @Test
    @DisplayName("Constructor should throw IllegalArgumentException for null, empty, or blank names")
    void testInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Student(null, 20, 75.0));
        assertThrows(IllegalArgumentException.class, () -> new Student("", 20, 75.0));
        assertThrows(IllegalArgumentException.class, () -> new Student("   ", 20, 75.0));
    }

    // 3. Defensive Validation Tests (Age: 16 to 100)
    @Test
    @DisplayName("Constructor should throw IllegalArgumentException for ages outside 16-100 range")
    void testInvalidAge() {
        assertThrows(IllegalArgumentException.class, () -> new Student("Bob", 15, 75.0));  // Too young
        assertThrows(IllegalArgumentException.class, () -> new Student("Bob", 101, 75.0)); // Too old
    }

    // 4. Defensive Validation Tests (Marks: 0 to 100)
    @Test
    @DisplayName("Constructor should throw IllegalArgumentException for marks outside 0-100 range")
    void testInvalidMarks() {
        assertThrows(IllegalArgumentException.class, () -> new Student("Charlie", 22, -0.1)); // Below 0
        assertThrows(IllegalArgumentException.class, () -> new Student("Charlie", 22, 100.1)); // Above 100
    }

    // 5. Behavioral Method: isPass (>= 50)
    @Test
    @DisplayName("isPass should return true for marks >= 50 and false otherwise")
    void testIsPass() {
        Student passingStudent = new Student("Dave", 21, 50.0);
        Student highAchiever = new Student("Eve", 19, 92.5);
        Student failingStudent = new Student("Frank", 23, 49.9);

        assertTrue(passingStudent.isPass());
        assertTrue(highAchiever.isPass());
        assertFalse(failingStudent.isPass());
    }

    // 6. Behavioral Method: getGrade
    @Test
    @DisplayName("getGrade should return correct letter grade based on marks scale")
    void testGetGrade() {
        assertEquals('A', new Student("S1", 20, 85.0).getGrade()); // 80+
        assertEquals('B', new Student("S2", 20, 72.0).getGrade()); // 70-79
        assertEquals('C', new Student("S3", 20, 64.0).getGrade()); // 60-69
        assertEquals('D', new Student("S4", 20, 51.0).getGrade()); // 50-59
        assertEquals('F', new Student("S5", 20, 45.0).getGrade()); // < 50
    }
}