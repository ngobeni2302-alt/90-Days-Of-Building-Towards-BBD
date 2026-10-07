import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    // 1. Multiplication Table Tests
    @Test
    @DisplayName("generateTable(5) should start at '5 x 1 = 5' and end at '5 x 10 = 50'")
    void testGenerateTable() {
        String[] table = Main.generateTable(5);

        // Verify length (must have 10 lines)
        assertEquals(10, table.length);

        // Verify first and last lines
        assertEquals("5 x 1 = 5", table[0]);
        assertEquals("5 x 10 = 50", table[9]);
    }

    // 2. Sum Tests
    @Test
    @DisplayName("calculateSum(5) should be 15 and calculateSum(10) should be 55")
    void testCalculateSum() {
        assertEquals(15, Main.calculateSum(5));
        assertEquals(55, Main.calculateSum(10));
    }

    // 3. Error Handling - Invalid Inputs (0 and negative numbers)
    @Test
    @DisplayName("Inputs <= 0 should throw IllegalArgumentException")
    void testInvalidInputs() {
        assertThrows(IllegalArgumentException.class, () -> Main.generateTable(0));
        assertThrows(IllegalArgumentException.class, () -> Main.generateTable(-5));

        assertThrows(IllegalArgumentException.class, () -> Main.calculateSum(0));
        assertThrows(IllegalArgumentException.class, () -> Main.calculateSum(-5));
    }

    // 4. Boundary Test (Inclusive check up to 10)
    @Test
    @DisplayName("generateTable should include the 10th multiplier explicitly (off-by-one check)")
    void testBoundaryInclusive() {
        String[] table = Main.generateTable(3);

        // Ensure the 10th element exists and evaluates correctly
        assertEquals("3 x 10 = 30", table[9]);
    }
}