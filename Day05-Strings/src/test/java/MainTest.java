import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    // 1. reverseString Tests
    @Test
    @DisplayName("reverseString should invert the order of characters")
    void testReverseString() {
        assertEquals("olleh", Main.reverseString("hello"));
        assertEquals("a", Main.reverseString("a"));
        assertEquals("", Main.reverseString(""));
    }

    // 2. isPalindrome Tests (Case-Insensitive)
    @Test
    @DisplayName("isPalindrome should identify palindromes regardless of letter casing")
    void testIsPalindrome() {
        assertTrue(Main.isPalindrome("racecar"));
        assertTrue(Main.isPalindrome("Racecar")); // Case-insensitive
        assertTrue(Main.isPalindrome("Madam"));   // Case-insensitive
        assertTrue(Main.isPalindrome("a"));
        assertTrue(Main.isPalindrome(""));

        assertFalse(Main.isPalindrome("hello"));
        assertFalse(Main.isPalindrome("java"));
    }

    // 3. countVowels Tests
    @Test
    @DisplayName("countVowels should count 'a, e, i, o, u' case-insensitively")
    void testCountVowels() {
        assertEquals(3, Main.countVowels("Hello World")); // e, o, o
        assertEquals(5, Main.countVowels("AEIOU"));       // Uppercase vowels
        assertEquals(0, Main.countVowels("rhythm"));      // No vowels
        assertEquals(0, Main.countVowels(""));            // Empty string
    }

    // 4. countWords Tests
    @Test
    @DisplayName("countWords should return correct word counts and handle extra whitespace")
    void testCountWords() {
        assertEquals(2, Main.countWords("Hello World"));
        assertEquals(1, Main.countWords("Java"));
        assertEquals(0, Main.countWords(""));             // Empty string has 0 words
        assertEquals(0, Main.countWords("   "));           // Whitespace-only string
        assertEquals(3, Main.countWords("  BBD   Software   Engineering  ")); // Trimmed spacing
    }

    // 5. Error Handling Tests (Null Checks)
    @Test
    @DisplayName("Null input should throw IllegalArgumentException for all methods")
    void testNullInputs() {
        assertThrows(IllegalArgumentException.class, () -> Main.reverseString(null));
        assertThrows(IllegalArgumentException.class, () -> Main.isPalindrome(null));
        assertThrows(IllegalArgumentException.class, () -> Main.countVowels(null));
        assertThrows(IllegalArgumentException.class, () -> Main.countWords(null));
    }
}