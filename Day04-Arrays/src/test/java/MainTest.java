import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private final int[] sampleArray = {10, 20, 5, 30, 15};

    // 1. findMax Tests
    @Test
    @DisplayName("findMax should return the largest element")
    void testFindMax() {
        assertEquals(30, Main.findMax(sampleArray));
        assertEquals(7, Main.findMax(new int[]{7})); // Single element
    }

    // 2. findMin Tests
    @Test
    @DisplayName("findMin should return the smallest element")
    void testFindMin() {
        assertEquals(5, Main.findMin(sampleArray));
        assertEquals(7, Main.findMin(new int[]{7})); // Single element
    }

    // 3. calculateSum Tests
    @Test
    @DisplayName("calculateSum should return the total sum of elements")
    void testCalculateSum() {
        assertEquals(80, Main.calculateSum(sampleArray));
        assertEquals(7, Main.calculateSum(new int[]{7})); // Single element
    }

    // 4. calculateAverage Tests (Precision & Decimal Check)
    @Test
    @DisplayName("calculateAverage should return exact double precision")
    void testCalculateAverage() {
        assertEquals(16.0, Main.calculateAverage(sampleArray), 0.001);

        // Tests integer truncation bug: 8 / 3 = 2.666... (not 2.0)
        int[] oddArray = {1, 3, 4};
        assertEquals(2.666, Main.calculateAverage(oddArray), 0.001);
    }

    // 5. reverseArray Tests
    @Test
    @DisplayName("reverseArray should return a new array with elements inverted")
    void testReverseArray() {
        int[] expected = {15, 30, 5, 20, 10};
        assertArrayEquals(expected, Main.reverseArray(sampleArray));

        // Ensure original array was not modified in place
        assertArrayEquals(new int[]{10, 20, 5, 30, 15}, sampleArray);
    }

    // 6. Error Handling Tests (Null & Empty Arrays)
    @Test
    @DisplayName("Null or empty arrays should throw IllegalArgumentException")
    void testInvalidInputs() {
        assertThrows(IllegalArgumentException.class, () -> Main.findMax(null));
        assertThrows(IllegalArgumentException.class, () -> Main.findMax(new int[]{}));

        assertThrows(IllegalArgumentException.class, () -> Main.findMin(null));
        assertThrows(IllegalArgumentException.class, () -> Main.findMin(new int[]{}));

        assertThrows(IllegalArgumentException.class, () -> Main.calculateSum(null));
        assertThrows(IllegalArgumentException.class, () -> Main.calculateSum(new int[]{}));

        assertThrows(IllegalArgumentException.class, () -> Main.calculateAverage(null));
        assertThrows(IllegalArgumentException.class, () -> Main.calculateAverage(new int[]{}));

        assertThrows(IllegalArgumentException.class, () -> Main.reverseArray(null));
        assertThrows(IllegalArgumentException.class, () -> Main.reverseArray(new int[]{}));
    }
}