package week4.day_2.queueinterface;

import java.util.*;

class BinaryNumberGenerator<T> {

    // Method to generate the first N binary numbers
    public List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1"); // Start with "1"

        for (int i = 0; i < N; i++) {
            String binary = queue.remove(); // Dequeue the front element
            result.add(binary);

            // Generate the next two binary numbers and enqueue them
            queue.add(binary + "0");
            queue.add(binary + "1");
        }

        return result;
    }
}

// Main class
public class GenerateBinaryNumberUsingQueue  {
    public static void main(String[] args) {
        int N = 5;
        BinaryNumberGenerator<String> generator = new BinaryNumberGenerator<>();
        List<String> binaryNumbers = generator.generateBinaryNumbers(N);

        System.out.println("First " + N + " Binary Numbers: " + binaryNumbers);
    }
}
