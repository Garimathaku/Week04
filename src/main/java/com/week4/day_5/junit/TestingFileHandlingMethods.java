package com.week4.day_5.junit;

import java.io.*;
import java.nio.file.*;

public class TestingFileHandlingMethods {

    // Method to write content to a file
    public static void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    // Method to read content from a file
    public static String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }

    // Method to check if the file exists
    public static boolean fileExists(String filename) {
        return Files.exists(Paths.get(filename));
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        TestingFileHandlingMethods fileProcessor = new TestingFileHandlingMethods();
        String filename = "testFile.txt";
        String content = "Hello, this is a test file!";

        try {
            // Write to the file
            fileProcessor.writeToFile(filename, content);
            System.out.println("Content written to file successfully.");

            // Check if the file exists
            if (fileProcessor.fileExists(filename)) {
                System.out.println("File exists.");
            } else {
                System.out.println("File does not exist.");
            }

            // Read from the file and display the content
            String readContent = fileProcessor.readFromFile(filename);
            System.out.println("Content read from file: " + readContent);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

