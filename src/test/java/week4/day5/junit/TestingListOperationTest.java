package week4.day5.junit;

import com.week4.day_5.junit.TestingListOperations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TestingListOperationTest {
    private TestingListOperations listManager;
    private List<Integer> list;

    @BeforeEach
    void setUp() {
        listManager = new TestingListOperations();
        list = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        listManager.addElement(list, 10);
        listManager.addElement(list, 20);
        assertEquals(2, list.size());
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
    }

    @Test
    void testRemoveElement() {
        listManager.addElement(list, 10);
        listManager.addElement(list, 20);
        assertTrue(listManager.removeElement(list, 10));
        assertFalse(list.contains(10));
        assertEquals(1, list.size());
        assertFalse(listManager.removeElement(list, 30)); // Trying to remove an element that doesn't exist
    }

    @Test
    void testGetSize() {
        assertEquals(0, listManager.getSize(list));
        listManager.addElement(list, 5);
        listManager.addElement(list, 15);
        assertEquals(2, listManager.getSize(list));
    }
}

