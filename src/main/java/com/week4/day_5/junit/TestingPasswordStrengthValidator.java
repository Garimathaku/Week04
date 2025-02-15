package com.week4.day_5.junit;


public class TestingPasswordStrengthValidator {

    // Method to validate the password
    public boolean validatePassword(String password) {
        // Check if password has at least 8 characters, one uppercase letter, and one digit
        if (password.length() >= 8 && containsUppercase(password) && containsDigit(password)) {
            return true;
        }
        return false;
    }

    // Helper method to check if password contains an uppercase letter
    private boolean containsUppercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to check if password contains a digit
    private boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    // Main method to test the PasswordValidator functionality
    public static void main(String[] args) {
        TestingPasswordStrengthValidator validator = new TestingPasswordStrengthValidator();

        // Test with valid password
        String validPassword = "Password1";
        System.out.println("Is valid password ('Password1')? " + validator.validatePassword(validPassword));

        // Test with invalid password (no uppercase letter)
        String invalidPassword1 = "password1";
        System.out.println("Is valid password ('password1')? " + validator.validatePassword(invalidPassword1));

        // Test with invalid password (no digit)
        String invalidPassword2 = "Password";
        System.out.println("Is valid password ('Password')? " + validator.validatePassword(invalidPassword2));

        // Test with invalid password (less than 8 characters)
        String invalidPassword3 = "Pass1";
        System.out.println("Is valid password ('Pass1')? " + validator.validatePassword(invalidPassword3));
    }
}

