package com.week4.day_5.regex;

public class CensorBadWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";

        // List of bad words (add more if needed)
        String[] badWords = {"damn", "stupid"};

        // Replace each bad word with ****
        for (String word : badWords) {
            String regex = "\\b" + word + "\\b";  // Ensure full-word match
            input = input.replaceAll("(?i)" + regex, "****"); // Case insensitive replacement
        }

        // Print the censored text
        System.out.println(input);
    }
}

