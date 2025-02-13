package week4.day3;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.week4.day_3.ConvertUppercaseToLowercase;

public class ConvertUppercaseToLowercaseTest{

    @Test
    void testConvertFileToLowercase() throws IOException {
        String inputFile = "src/test/java/week4/day3/source.txt";
        String outputFile = "src/test/java/week4/day3/desti.txt";

        File source = new File(inputFile);
        assertTrue(source.exists(), "Source file should exist before conversion");

        ConvertUppercaseToLowercase.convertFileToLowercase(inputFile, outputFile);

        File destination = new File(outputFile);
        assertTrue(destination.exists(), "Destination file should exist after conversion");

        String sourceContent = new String(Files.readAllBytes(Paths.get(inputFile)));
        String destinationContent = new String(Files.readAllBytes(Paths.get(outputFile)));

        assertEquals(sourceContent.toLowerCase(), destinationContent, "Converted file contents should be in lowercase");
    }
}

