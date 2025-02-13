package com.week4.day_3;
import java.io.*;
import java.nio.file.*;

public class ReadLargeFileLineByLine{

    private static final String FILE_PATH = "src/main/java/com/week4/day_3/Source.txt";
    private static final long FILE_SIZE_MB = 500; // Target file size in MB


    public static void createLargeFile() {
        File file = new File(FILE_PATH);

        // Ensure the parent directory exists
        file.getParentFile().mkdirs();

        String sampleText = "This is me this side." +
                "\nWhat are you doing.\nError Something goes on\n";
        long fileSize = 0;

        System.out.println("⏳ Creating a large file...");

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH))) {
            while (fileSize < FILE_SIZE_MB * 1024 * 1024) {
                writer.write(sampleText);
                fileSize += sampleText.getBytes().length;
            }
            System.out.println(" Large file created successfully: " + FILE_PATH + " (Size: " + FILE_SIZE_MB + "MB+)");
        } catch (IOException e) {
            System.err.println(" Error creating large file: " + e.getMessage());
        }
    }

    //   Read Large File & Print Lines Containing "error"
    public static void readLargeFile() {
        System.out.println("\n⏳ Reading file and filtering 'error' lines...\n");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) { // Case-insensitive search
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println(" Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        createLargeFile();
        readLargeFile();
    }
}
