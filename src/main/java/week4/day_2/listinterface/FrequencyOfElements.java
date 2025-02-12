package week4.day_2.listinterface;


import java.util.*;
public class FrequencyOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user for input size
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Create a list to store user input
        List<String> list = new ArrayList<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine()); // Read elements from user
        }

        sc.close();

        // Calculate and display the frequency of elements
        Map<String, Integer> frequencyMap = getFrequencyMap(list);
        System.out.println("Frequency of elements: " + frequencyMap);
    }

    public static Map<String, Integer> getFrequencyMap(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : list) {
            // Increment frequency count for each element
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }
}
