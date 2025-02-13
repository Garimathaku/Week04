package week4.day3;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import com.week4.day_3.CountWordsInFile;

public class CountWordsInFileTest {

    @Test
    void testWordFrequencyCount() {
        String filePath = "src/test/java/week4/day3/source.txt";
        File source = new File(filePath);
        assertTrue(source.exists(), "Source file should exist before counting words");

        Map<String, Integer> wordCountMap = CountWordsInFile.countWordFrequency();
        assertNotNull(wordCountMap, "Word count map should not be null");
        assertFalse(wordCountMap.isEmpty(), "Word count map should not be empty");
    }

    @Test
    void testTopWordsDisplay() {
        Map<String, Integer> wordCountMap = CountWordsInFile.countWordFrequency();
        assertNotNull(wordCountMap, "Word count map should not be null");
        assertTrue(wordCountMap.size() > 0, "Word count map should contain words");
    }
}
