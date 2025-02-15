package week4.day5.junit;


import com.week4.day_5.junit.TestingTemperatureConverter;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TestingTemperatureConverterTest {

    private TestingTemperatureConverter temperatureConverter;

    @BeforeEach
    void setUp() {
        temperatureConverter = new TestingTemperatureConverter();
    }

    // Test Celsius to Fahrenheit conversion
    @Test
    void testCelsiusToFahrenheit() {
        double celsius = 25.0;
        double expectedFahrenheit = 77.0;
        assertEquals(expectedFahrenheit, temperatureConverter.celsiusToFahrenheit(celsius), "25°C should equal 77°F");
    }

    // Test Fahrenheit to Celsius conversion
    @Test
    void testFahrenheitToCelsius() {
        double fahrenheit = 77.0;
        double expectedCelsius = 25.0;
        assertEquals(expectedCelsius, temperatureConverter.fahrenheitToCelsius(fahrenheit), "77°F should equal 25°C");
    }

    // Test negative Celsius to Fahrenheit conversion
    @Test
    void testNegativeCelsiusToFahrenheit() {
        double celsius = -10.0;
        double expectedFahrenheit = 14.0;
        assertEquals(expectedFahrenheit, temperatureConverter.celsiusToFahrenheit(celsius), "-10°C should equal 14°F");
    }

    // Test negative Fahrenheit to Celsius conversion
    @Test
    void testNegativeFahrenheitToCelsius() {
        double fahrenheit = -4.0;
        double expectedCelsius = -20.0;
        assertEquals(expectedCelsius, temperatureConverter.fahrenheitToCelsius(fahrenheit), "-4°F should equal -20°C");
    }

    @AfterEach
    void tearDown() {
        temperatureConverter = null;
    }
}

