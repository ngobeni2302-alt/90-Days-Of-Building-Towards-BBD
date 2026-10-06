import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    //Testing for 80 - 100 :Grade A
    @Test
    @DisplayName("Marks 80, 85, and 100 should return Grade A")
    void testGradeA(){
        assertEquals("A", Main.getGrade(80));
        assertEquals("A", Main.getGrade(85));
        assertEquals("A", Main.getGrade(100));
    }

    //Testing for 60 - 79: Grade B
    @Test
    @DisplayName("Marks 60, 65 and 79 should return Grade B")
    void testGradeB(){
        assertEquals("B", Main.getGrade(60));
        assertEquals("B", Main.getGrade(65));
        assertEquals("B", Main.getGrade(79));
    }

    //Testing for 50 - 59: Grade C
    @Test
    @DisplayName("Marks 50, 55 and 59 should return Grade C")
    void testGradeC(){
        assertEquals("C", Main.getGrade(50));
        assertEquals("C", Main.getGrade(55));
        assertEquals("C", Main.getGrade(59));
    }

    //Testing for 0 - 49: Grade F
    @Test
    @DisplayName("Marks 0, 25 and 49 should return Grade F")
    void testGradeF(){
        assertEquals("F", Main.getGrade(0));
        assertEquals("F", Main.getGrade(25));
        assertEquals("F", Main.getGrade(49));
    }

    //Testing for Invalid marks [>100 or <0]
    @Test
    @DisplayName("Marks greater than 100 and less than 0 should throw IllegalArguemtException")
    void testInvalidMarks(){
        assertThrows(IllegalArgumentException.class, () -> Main.getGrade(101));
        assertThrows(IllegalArgumentException.class, () -> Main.getGrade(105));
        assertThrows(IllegalArgumentException.class, () -> Main.getGrade(-1));
    }

    //Testing that it reads 79 as B and 80 as A
    @Test
    @DisplayName("Boundary Check: 79 is B and 80 is A")
    void testBoundaryMarks(){
        assertEquals("B", Main.getGrade(79));
        assertEquals("A", Main.getGrade(80));
        assertNotEquals(Main.getGrade(79), Main.getGrade(80));
    }

    //Testing the Boundary Message Helper
    @Test
    @DisplayName("getMessage returns correct feedback string per grade")
    void testGetMessage(){
        assertEquals("Excellent! - BBD level", Main.getMessage("A"));
        assertEquals("Good job!", Main.getMessage("B"));
        assertEquals("Pass - keep cooking", Main.getMessage("C"));
        assertEquals("Fail - try again", Main.getMessage("F"));
    }
}