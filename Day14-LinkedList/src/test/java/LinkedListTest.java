import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void testAddAndGet() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(2));
    }

    @Test
    public void testAddFirst() {
        LinkedList<String> list = new LinkedList<>();
        list.add("B");
        list.addFirst("A");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    public void testRemove() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.remove(1); // Removes "B"
        assertEquals(2, list.size());
        assertEquals("C", list.get(1));
    }

    @Test
    public void testReverse() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.reverse();
        assertEquals(3, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(1, list.get(2));
    }

    @Test
    public void testOutOfBounds() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
    }
}