package com.week4.day_3;

import java.io.*;
import java.util.*;

public class CountWordsInFile {
    private static final String FILE_PATH = "src/main/java/com/week4/day_3/Source.txt"; // File path

    // Method to count word frequency from the file
    public static Map<String, Integer> countWordFrequency() {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Remove punctuation and convert to lowercase
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return wordCountMap;
    }

    // Method to display top 5 most frequent words
    public static void displayTopWords(Map<String, Integer> wordCountMap) {
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordCountMap.entrySet());

        // Sort words by frequency in descending order
        wordList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, wordList.size()); i++) {
            System.out.println(wordList.get(i).getKey() + "  " + wordList.get(i).getValue());
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> wordCountMap = countWordFrequency(); // Step 1: Count Words
        displayTopWords(wordCountMap); // Step 2: Display Top 5 Words
    }
}

