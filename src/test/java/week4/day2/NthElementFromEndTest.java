package week4.day2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import week4.day_2.listinterface.NthElementFromEnd;

import java.util.*;

public class NthElementFromEndTest {

    @Test
    public void testFindNthFromEnd() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("a", "b", "c", "d", "e"));
        assertEquals("d", NthElementFromEnd.findNthFromEnd(list, 2), "Expected element at 2nd position from end is 'd'");
        assertEquals("e", NthElementFromEnd.findNthFromEnd(list, 1), "Expected element at 1st position from end is 'e'");
        assertEquals("a", NthElementFromEnd.findNthFromEnd(list, 5), "Expected element at 5th position from end is 'a'");
    }

    @Test
    public void testFindNthFromEndInvalidN() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("a", "b", "c"));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NthElementFromEnd.findNthFromEnd(list, 4);
        });
        assertEquals("N is larger than the list size", exception.getMessage(), "Expected exception message for N larger than list size");
    }
}
