package week4.day5.junit;

import com.week4.day_5.junit.TestingParameterizedProblem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestingParameterizedTest {
    private final TestingParameterizedProblem tester = new TestingParameterizedProblem();

    @Test
    void testIsEven_WithEvenNumbers() {
        assertTrue(tester.isEven(2), "2 should be even.");
        assertTrue(tester.isEven(4), "4 should be even.");
        assertTrue(tester.isEven(6), "6 should be even.");
    }

    @Test
    void testIsEven_WithOddNumbers() {
        assertFalse(tester.isEven(7), "7 should be odd.");
        assertFalse(tester.isEven(9), "9 should be odd.");
    }
}
