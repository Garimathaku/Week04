package com.week4.day_3;
import java.io.*;

public class ReadAndWriteTextFileUsingFileHandling {
    public static void main(String[] args) {
        // Define the source and destination file paths
        String sourceFile = "src/main/java/week4/day_3/Source.txt";
        String destinationFile = "src/main/java/week4/day_3/destination.txt";
        // Call the copyFile method to perform file copying
        copyFile(sourceFile, destinationFile);
    }

    public static void copyFile(String source, String destination) {
        FileInputStream fis = null; // File input stream for reading the file
        FileOutputStream fos = null; // File output stream for writing to the new file

        try {
            File inputFile = new File(source);

            // Check if the source file exists before proceeding
            if (!inputFile.exists()) {
                System.out.println("Source file does not exist: " + source);
                return; // Exit the method if the source file is missing
            }

            // Open the input stream to read the file
            fis = new FileInputStream(inputFile);

            // Open the output stream to write to the destination file
            fos = new FileOutputStream(destination);

            byte[] buffer = new byte[1024]; // Buffer to read chunks of data
            int bytesRead;

            // Read from source file and write to destination file in chunks
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            // Handle any IO exceptions that may occur
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Ensure streams are closed properly to avoid resource leaks
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();  
            } catch (IOException e) {
                System.out.println("Error closing the file streams: " + e.getMessage());
            }
        }
    }
}

