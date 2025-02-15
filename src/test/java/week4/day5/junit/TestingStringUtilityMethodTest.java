package week4.day5.junit;


import com.week4.day_5.junit.TestingStringUtilityMethod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestingStringUtilityMethodTest {
    private TestingStringUtilityMethod stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new TestingStringUtilityMethod();
    }

    @Test
    void testReverse() {
        assertEquals("olleH", TestingStringUtilityMethod.reverse("Hello"));
        assertEquals("987654321", TestingStringUtilityMethod.reverse("123456789"));
        assertNull(TestingStringUtilityMethod.reverse(null));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(TestingStringUtilityMethod.isPalindrome("madam"));
        assertTrue(TestingStringUtilityMethod.isPalindrome("Racecar"));
        assertFalse(TestingStringUtilityMethod.isPalindrome("Hello"));

    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", TestingStringUtilityMethod.toUpperCase("hello"));
        assertEquals("JAVA", TestingStringUtilityMethod.toUpperCase("Java"));

    }
}
