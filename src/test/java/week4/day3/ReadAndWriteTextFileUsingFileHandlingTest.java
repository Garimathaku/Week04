package week4.day3;


import static org.junit.jupiter.api.Assertions.*;

import com.week4.day_3.ReadAndWriteTextFileUsingFileHandling;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadAndWriteTextFileUsingFileHandlingTest {

    @Test
    void testFileCopy() throws IOException {
        // Define source and destination file paths
        String sourceFile = "src/test/java/week4/day3/source.txt";
        String destinationFile = "src/test/java/week4/day3/desti.txt";

        // Ensure source file exists
        File source = new File(sourceFile);
        assertTrue(source.exists(), "Source file should exist before copying");

        // Call the method to copy the file
        ReadAndWriteTextFileUsingFileHandling.copyFile(sourceFile, destinationFile);

        // Ensure destination file exists after copying
        File destination = new File(destinationFile);
        assertTrue(destination.exists(), "Destination file should exist after copying");

        // Validate that contents of both files are identical
        byte[] sourceContent = Files.readAllBytes(Paths.get(sourceFile));
        byte[] destinationContent = Files.readAllBytes(Paths.get(destinationFile));
        assertArrayEquals(sourceContent, destinationContent, "File contents should be identical after copy");
    }
}

