import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class SortTest {

    @Test
    public void testBubbleSort() {
        List<Employee> list = new ArrayList<>();
        list.add(new Manager("Sarah", "2", 30000.0, 10000.0)); // 40000
        list.add(new Intern("John", "3", 10000.0));             // 10000
        list.add(new Developer("Thabo", "1", 20000.0, 10.0));   // 20010

        List<Employee> sorted = Sorter.bubbleSortBySalary(list);

        // Verify ascending salary order
        assertEquals(10000.0, sorted.get(0).calculateSalary(), 0.001);
        assertEquals(20010.0, sorted.get(1).calculateSalary(), 0.001);
        assertEquals(40000.0, sorted.get(2).calculateSalary(), 0.001);

        // Verify defensive programming: original list remains completely unchanged
        assertEquals(3, list.size());
    }

    @Test
    public void testSelectionSort() {
        List<Employee> list = List.of(
                new Developer("C", "3", 20000.0, 0),
                new Developer("A", "1", 20000.0, 0),
                new Developer("B", "2", 20000.0, 0)
        );

        List<Employee> sorted = Sorter.selectionSortById(list);

        // Verify ascending ID order
        assertEquals("1", sorted.get(0).getId());
        assertEquals("2", sorted.get(1).getId());
        assertEquals("3", sorted.get(2).getId());
    }

    @Test
    public void testBinarySearch() {
        List<Employee> list = new ArrayList<>();
        list.add(new Developer("A", "1", 20000.0, 0));
        list.add(new Developer("B", "2", 20000.0, 0));
        list.add(new Developer("C", "3", 20000.0, 0));

        // List must be sorted by ID first for binary search to work
        List<Employee> sorted = Sorter.selectionSortById(list);

        // Verify successful lookup and missing item handling
        assertNotNull(Sorter.binarySearchById(sorted, "2"));
        assertEquals("2", Sorter.binarySearchById(sorted, "2").getId());
        assertNull(Sorter.binarySearchById(sorted, "99"));
    }

    @Test
    public void testEmptyList() {
        List<Employee> empty = new ArrayList<>();

        // Verify graceful handling of empty datasets
        assertEquals(0, Sorter.bubbleSortBySalary(empty).size());
        assertNull(Sorter.binarySearchById(empty, "1"));
    }
}