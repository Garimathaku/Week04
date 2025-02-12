package week4.day_2.mapinterface;

import java.util.*;

class MaxValueKeyFinder<K, V extends Comparable<V>> {
    public K findMaxKey(Map<K, V> map) {
        K maxKey = null;
        V maxValue = null;

        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (maxValue == null || entry.getValue().compareTo(maxValue) > 0) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}
// Main class
public class KeyWithHighestValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> inputMap = new HashMap<>();

        System.out.println("Enter the number of entries: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter key (String): ");
            String key = sc.nextLine();
            System.out.println("Enter value (Integer): ");
            int value = sc.nextInt();
            sc.nextLine(); // Consume newline
            inputMap.put(key, value);
        }

        sc.close();

        MaxValueKeyFinder<String, Integer> finder = new MaxValueKeyFinder<>();
        String maxKey = finder.findMaxKey(inputMap);

        System.out.println("Key with the highest value: " + maxKey);
    }
}

