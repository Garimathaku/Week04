package week4.day5.junit;


import com.week4.day_5.junit.TestingPasswordStrengthValidator;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TestingPasswordStrengthValidatorTest {

    private TestingPasswordStrengthValidator passwordValidator;

    @BeforeEach
    void setUp() {
        passwordValidator = new TestingPasswordStrengthValidator();
    }

    // Test for a valid password
    @Test
    void testValidPassword() {
        assertTrue(passwordValidator.validatePassword("Password1"), "Password should be valid.");
    }

    // Test for a password with no uppercase letter
    @Test
    void testPasswordNoUppercase() {
        assertFalse(passwordValidator.validatePassword("password1"), "Password should be invalid due to missing uppercase letter.");
    }

    // Test for a password with no digit
    @Test
    void testPasswordNoDigit() {
        assertFalse(passwordValidator.validatePassword("Password"), "Password should be invalid due to missing digit.");
    }

    // Test for a password with less than 8 characters
    @Test
    void testPasswordTooShort() {
        assertFalse(passwordValidator.validatePassword("Pass1"), "Password should be invalid due to being too short.");
    }

    // Test for an empty password
    @Test
    void testPasswordEmpty() {
        assertFalse(passwordValidator.validatePassword(""), "Password should be invalid due to being empty.");
    }

    @AfterEach
    void tearDown() {
        passwordValidator = null;
    }
}

