package com.week4.day_5.regex;

import java.util.regex.*;

public class ValidateSocialSecurityNumber {
    public static boolean isValidSSN(String ssn) {
        String pattern = "^(\\d{3}-\\d{2}-\\d{4})$";

        // Compile regex pattern
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(ssn);

        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        String[] ssnNumbers = {
                "123-45-6789",
                "123456789",
                "12-345-6789",
                "123-456-789",
                "987-65-4321"
        };

        for (String ssn : ssnNumbers) {
            System.out.println("\"" + ssn + "\" is " + (isValidSSN(ssn) ? "Valid ✅" : "Invalid ❌"));
        }
    }
}

