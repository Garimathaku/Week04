package com.week4.day_5.junit;

public class TestingTemperatureConverter {

    // Method to convert Celsius to Fahrenheit
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Main method to test the TemperatureConverter functionality
    public static void main(String[] args) {
        TestingTemperatureConverter converter = new TestingTemperatureConverter();

        // Test Celsius to Fahrenheit
        double celsius = 25.0;
        double fahrenheit = converter.celsiusToFahrenheit(celsius);
        System.out.println(celsius + "°C = " + fahrenheit + "°F");

        // Test Fahrenheit to Celsius
        fahrenheit = 77.0;
        celsius = converter.fahrenheitToCelsius(fahrenheit);
        System.out.println(fahrenheit + "°F = " + celsius + "°C");
    }
}

