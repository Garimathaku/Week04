package week4.day5.junit;


import com.week4.day_5.junit.TestingDateFormatter;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TestingDateFormatterTest {

    private TestingDateFormatter dateFormatter;

    @BeforeEach
    void setUp() {
        dateFormatter = new TestingDateFormatter();
    }

    // Test valid date conversion
    @Test
    void testValidDate() {
        String inputDate = "2025-02-15";
        String expectedDate = "15-02-2025";
        assertEquals(expectedDate, dateFormatter.formatDate(inputDate), "Valid date should be formatted correctly.");
    }

    // Test invalid date format
    @Test
    void testInvalidDateFormat() {
        String inputDate = "2025-15-02";  // Invalid date format
        String expectedMessage = "Invalid date format";
        assertEquals(expectedMessage, dateFormatter.formatDate(inputDate), "Invalid date should return an error message.");
    }

    // Test empty date input
    @Test
    void testEmptyDate() {
        String inputDate = "";
        String expectedMessage = "Invalid date format";
        assertEquals(expectedMessage, dateFormatter.formatDate(inputDate), "Empty date should return an error message.");
    }

    // Test null date input
    @Test
    void testNullDate() {
        String inputDate = null;
        String expectedMessage = "Invalid date format";
        assertEquals(expectedMessage, dateFormatter.formatDate(inputDate), "Null date should return an error message.");
    }

    @AfterEach
    void tearDown() {
        dateFormatter = null;
    }
}

