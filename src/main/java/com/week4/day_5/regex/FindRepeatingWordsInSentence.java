package com.week4.day_5.regex;

import java.util.*;
import java.util.regex.*;

public class FindRepeatingWordsInSentence{
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        // Regex pattern to extract words (ignoring punctuation)
        String pattern = "\\b(\\w+)\\b";

        // Compile regex pattern
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);

        // Store word counts
        Map<String, Integer> wordCount = new HashMap<>();

        // Find words and count occurrences
        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Convert to lowercase for case insensitivity
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Print repeating words
        List<String> repeatingWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                repeatingWords.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", repeatingWords));
    }
}

