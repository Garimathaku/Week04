package week4.day5.junit;


import com.week4.day_5.junit.TestingUserRegistration;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TestingUserRegistrationTest {

    private TestingUserRegistration userRegistration;

    @BeforeEach
    void setUp() {
        userRegistration = new TestingUserRegistration();
    }

    // Test valid user registration
    @Test
    void testValidRegistration() {
        try {
            userRegistration.registerUser("john_doe", "john.doe@example.com", "password123");
        } catch (IllegalArgumentException e) {
            fail("Registration failed for valid inputs: " + e.getMessage());
        }
    }

    // Test empty username
    @Test
    void testEmptyUsername() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("", "john.doe@example.com", "password123");
        });
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    // Test invalid email format
    @Test
    void testInvalidEmail() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("john_doe", "john.doeexample.com", "password123");
        });
        assertEquals("Invalid email format", exception.getMessage());
    }

    // Test short password
    @Test
    void testShortPassword() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("john_doe", "john.doe@example.com", "pass");
        });
        assertEquals("Password must be at least 8 characters long", exception.getMessage());
    }

    @AfterEach
    void tearDown() {
        userRegistration = null;
    }
}

