package com.week4.day_5.regex;

import java.util.regex.*;
import java.util.*;

public class ExtractProgrammingLanguageNames{
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // List of programming languages (extend this list as needed)
        String[] languages = {"JavaScript", "Java", "Python", "Go", "C", "C++", "Ruby", "Swift", "Kotlin"};

        // Regex pattern to match programming languages
        String pattern = "\\b(" + String.join("|", languages) + ")\\b";

        // Compile regex pattern
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);

        // Store extracted language names
        List<String> extractedLanguages = new ArrayList<>();
        while (matcher.find()) {
            extractedLanguages.add(matcher.group());
        }

        // Print extracted languages
        System.out.println(String.join(", ", extractedLanguages));
    }
}

