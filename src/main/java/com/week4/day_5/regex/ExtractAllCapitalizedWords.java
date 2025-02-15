package com.week4.day_5.regex;

import java.util.regex.*;
import java.util.*;

public class ExtractAllCapitalizedWords {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        // Regex pattern to match capitalized words
        String pattern = "\\b[A-Z][a-z]*\\b";

        // Compile regex pattern
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);

        // Store capitalized words in a list
        List<String> capitalizedWords = new ArrayList<>();
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        // Print result
        System.out.println(String.join(", ", capitalizedWords));
    }
}

