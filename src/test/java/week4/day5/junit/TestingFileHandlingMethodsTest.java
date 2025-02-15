package week4.day5.junit;

import com.week4.day_5.junit.TestingFileHandlingMethods;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class TestingFileHandlingMethodsTest {

    private static final String TEST_FILENAME = "src/test/java/week4/day5/source.txt";
    private TestingFileHandlingMethods fileProcessor;

    // Test if content is written and read correctly
    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, world!";
        TestingFileHandlingMethods.writeToFile(TEST_FILENAME, content);

        // Read the content from file and verify
        String readContent = TestingFileHandlingMethods.readFromFile(TEST_FILENAME);
        assertEquals(content, readContent);
    }

    // Test if file exists after writing
    @Test
    void testFileExistsAfterWriting() throws IOException {
        String content = "This is a test.";
        TestingFileHandlingMethods.writeToFile(TEST_FILENAME, content);

        // Check if file exists
        assertTrue(TestingFileHandlingMethods.fileExists(TEST_FILENAME));
    }

    // Test handling of IOException when file doesn't exist
    @Test
    void testIOExceptionForNonExistentFile() {
        // Pass an invalid file path to trigger IOException
        assertThrows(IOException.class, () -> TestingFileHandlingMethods.readFromFile("nonExistentFile.txt"));
    }

    // Clean up after tests
    @AfterEach
    void tearDown() {
        try {
            Files.deleteIfExists(Paths.get(TEST_FILENAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

