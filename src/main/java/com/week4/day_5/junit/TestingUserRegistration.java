package com.week4.day_5.junit;


public class TestingUserRegistration {

    // Method to register a user
    public void registerUser(String username, String email, String password) {
        // Validate username
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        // Validate email
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        // Validate password
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        // If all validations pass, registration is successful
        System.out.println("User registered successfully: " + username);
    }

    // Main method to test the UserRegistration functionality
    public static void main(String[] args) {
        TestingUserRegistration userRegistration = new TestingUserRegistration();

        // Test valid user registration
        try {
            userRegistration.registerUser("john_doe", "john.doe@example.com", "password123");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test invalid user registration (empty username)
        try {
            userRegistration.registerUser("", "john.doe@example.com", "password123");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test invalid user registration (invalid email)
        try {
            userRegistration.registerUser("john_doe", "john.doeexample.com", "password123");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test invalid user registration (short password)
        try {
            userRegistration.registerUser("john_doe", "john.doe@example.com", "pass");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

