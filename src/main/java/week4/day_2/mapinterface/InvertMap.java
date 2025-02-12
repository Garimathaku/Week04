package week4.day_2.mapinterface;

import java.util.*;

class MapInverter<K, V> {
    // Method to invert a Map<K, V> to Map<V, List<K>>
    public Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            invertedMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        return invertedMap;
    }
}

// Main class to test the map inversion
public class InvertMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> inputMap = new HashMap<>();

        System.out.println("Enter the number of entries: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter key (String): ");
            String key = scanner.nextLine();
            System.out.println("Enter value (Integer): ");
            int value = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            inputMap.put(key, value);
        }

        scanner.close();

        MapInverter<String, Integer> inverter = new MapInverter<>();
        Map<Integer, List<String>> invertedMap = inverter.invertMap(inputMap);

        System.out.println("Inverted Map: " + invertedMap);
    }
}
