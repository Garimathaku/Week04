package com.week4.day_5.regex;

import java.util.regex.*;

public class ValidateCreditCard {
    public static boolean isValidCreditCard(String cardNumber) {
        // Regex for Visa (starts with 4) and MasterCard (starts with 5), both with exactly 16 digits
        String pattern = "^(4[0-9]{15}|5[0-9]{15})$";

        // Compile regex pattern
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(cardNumber);

        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        String[] cardNumbers = {
                "4111111111111111",
                "5105105105105100",
                "4111111111111",
                "51111111111111111",
                "6111111111111111",
                "4222222222222222"
        };

        for (String card : cardNumbers) {
            System.out.println(card + " -> " + (isValidCreditCard(card) ? "Valid" : "Invalid"));
        }
    }
}

