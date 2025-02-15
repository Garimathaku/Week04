package com.week4.day_5.regex;

import java.util.regex.*;

public class ExtractEmailAddress  {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org. You can also reach out to help@service.net!";

        // Regex pattern for email extraction
        String pattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        // Compile regex pattern
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);

        // Find and print all emails
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

