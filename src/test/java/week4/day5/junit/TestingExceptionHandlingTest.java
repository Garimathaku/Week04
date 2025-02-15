package week4.day5.junit;

import com.week4.day_5.junit.TestingExceptionHandling;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestingExceptionHandlingTest {
    private TestingExceptionHandling calculator;

    @BeforeEach
    void setUp() {
        calculator = new TestingExceptionHandling();
    }

    @Test
    void testDivideValidNumbers() {
        assertEquals(2, calculator.divide(10, 5));
        assertEquals(-3, calculator.divide(-9, 3));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}

