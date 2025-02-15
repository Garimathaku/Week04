package com.week4.day_5.regex;

import java.util.regex.*;
import java.util.*;

public class ExtractCurrencyValues {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        // Regex pattern to match currency values (with or without $ sign)
        String pattern = "\\$?\\b\\d+\\.\\d{2}\\b";

        // Compile regex pattern
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);

        // Store extracted values
        List<String> currencyValues = new ArrayList<>();
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }

        // Print extracted currency values
        System.out.println(String.join(", ", currencyValues));
    }
}

