import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testAddition() {
        assertEquals(12.5, Main.calculate(10.5, '+', 2.0), 0.001);
    }

    @Test
    public void testSubtraction() {
        assertEquals(8.0, Main.calculate(10.0, '-', 2.0), 0.001);
    }

    @Test
    public void testMultiplication() {
        assertEquals(15.0, Main.calculate(5.0, '*', 3.0), 0.001);
    }

    @Test
    public void testDivision() {
        assertEquals(2.5, Main.calculate(5.0, '/', 2.0), 0.001);
    }

    @Test
    public void testDivisionByZeroThrows() {
        assertThrows(ArithmeticException.class, () -> {
            Main.calculate(10.0, '/', 0.0);
        });
    }

    @Test
    public void testInvalidOperatorThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            Main.calculate(10.0, '%', 2.0);
        });
    }

    @Test
    public void testDoubleVsInt() {
        // This is the BBD thinking test - 5/2 should be 2.5 not 2
        assertEquals(2.5, Main.calculate(5, '/', 2), 0.001);
    }
}