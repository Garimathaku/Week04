package week4.day2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import week4.day_2.listinterface.ReverseAList;

import java.util.*;

public class ReverseAListTest {

    @Test
    public void testReverseListWithArrayList() {
        List<Integer> inputList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> expectedList = Arrays.asList(5, 4, 3, 2, 1);


        ReverseAList.reverseList(inputList);

        assertEquals(expectedList, inputList, "The reversed ArrayList does not match the expected values.");
    }

    @Test
    public void testReverseListWithLinkedList() {
        List<Integer> inputList = new LinkedList<>(Arrays.asList(10, 20, 30, 40));
        List<Integer> expectedList = Arrays.asList(40, 30, 20, 10);

        ReverseAList.reverseList(inputList);

        assertEquals(expectedList, inputList, "The reversed LinkedList does not match the expected values.");
    }

    @Test
    public void testReverseListWithEmptyList() {
        List<Integer> inputList = new ArrayList<>();
        List<Integer> expectedList = new ArrayList<>();

        ReverseAList.reverseList(inputList);

        assertEquals(expectedList, inputList, "The function should return an empty list when input is empty.");
    }
}
