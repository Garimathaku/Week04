package week4.day_2.listinterface;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get list size from user
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<String> list = new ArrayList<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }
        scanner.close();

        // Remove duplicates while preserving order
        List<String> uniqueList = removeDuplicates(list);

        // Display result
        System.out.println("List after removing duplicates: " + uniqueList);
    }

    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>();
        List<T> result = new ArrayList<>();

        for (T item : list) {
            if (seen.add(item)) { // Only add if not already in set
                result.add(item);
            }
        }
        return result;
    }
}
