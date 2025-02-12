package week4.day2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import week4.day_2.listinterface.RemoveDuplicates;

import java.util.*;

public class RemoveDuplicatesTest {

    @Test
    public void testRemoveDuplicates() {
        List<String> inputList = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");
        List<String> expectedList = Arrays.asList("apple", "banana", "orange", "grape");

        assertEquals(expectedList, RemoveDuplicates.removeDuplicates(inputList), "The list after removing duplicates does not match the expected values.");
    }

    @Test
    public void testRemoveDuplicatesWithNoDuplicates() {
        List<String> inputList = Arrays.asList("car", "bike", "bus");
        List<String> expectedList = Arrays.asList("car", "bike", "bus");

        assertEquals(expectedList, RemoveDuplicates.removeDuplicates(inputList), "The function should return the same list when no duplicates are present.");
    }

    @Test
    public void testRemoveDuplicatesWithEmptyList() {
        List<String> inputList = new ArrayList<>();
        List<String> expectedList = new ArrayList<>();

        assertEquals(expectedList, RemoveDuplicates.removeDuplicates(inputList), "The function should return an empty list when input is empty.");
    }
}
