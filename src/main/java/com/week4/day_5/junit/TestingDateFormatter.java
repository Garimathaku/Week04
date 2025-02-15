package com.week4.day_5.junit;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestingDateFormatter {

    // Method to convert date from yyyy-MM-dd format to dd-MM-yyyy format
    public String formatDate(String inputDate) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
            return "Invalid date format";
        }
    }

    // Main method to test the DateFormatter functionality
    public static void main(String[] args) {
        TestingDateFormatter dateFormatter = new TestingDateFormatter ();

        // Test valid date
        String validDate = "2025-02-15";
        System.out.println("Formatted Date: " + dateFormatter.formatDate(validDate));

        // Test invalid date
        String invalidDate = "2025-15-02";
        System.out.println("Formatted Date: " + dateFormatter.formatDate(invalidDate));
    }
}

