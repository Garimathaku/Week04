package week4.day_2.mapinterface;

import java.util.*;

class FrequencyCounter<T extends String> {
    private Map<T, Integer> wordCountMap;

    // Constructor
    public FrequencyCounter() {
        wordCountMap = new HashMap<>();
    }

    // Method to process text and count word frequencies
    public void processText(String text) {
        // Normalize text: convert to lowercase and remove punctuation
        text = text.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");

        String[] words = text.split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCountMap.put((T) word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
    }

    // Method to get word frequency map
    public Map<T, Integer> getWordFrequencies() {
        return wordCountMap;
    }
}

// Main class to test the word frequency counter
public class WordFrequencyCounter{
    public static void main(String[] args) {
        FrequencyCounter<String> counter = new FrequencyCounter<>();

        String inputText = "Hello world, hello Java!";
        counter.processText(inputText);

        System.out.println("Word Frequencies: " + counter.getWordFrequencies());
    }
}

