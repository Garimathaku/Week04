package week4.day2;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import week4.day_2.listinterface.FrequencyOfElements;

import java.util.*;

public class FrequencyOfElementsTest {

    @Test
    public void testFrequencyOfElements() {
        List<String> inputList = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana");
        Map<String, Integer> expectedFrequency = new HashMap<>();
        expectedFrequency.put("apple", 2);
        expectedFrequency.put("banana", 3);
        expectedFrequency.put("orange", 1);

        Map<String, Integer> actualFrequency = FrequencyOfElements.getFrequencyMap(inputList);

        assertEquals(expectedFrequency, actualFrequency, "The frequency map does not match the expected values.");
    }
}

