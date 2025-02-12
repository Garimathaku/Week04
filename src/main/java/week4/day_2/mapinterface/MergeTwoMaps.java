package week4.day_2.mapinterface;


import java.util.*;

// Generic class to merge two maps
class MapMerger<K, V extends Number> {
    public Map<K, V> mergeMaps(Map<K, V> map1, Map<K, V> map2) {
        Map<K, V> mergedMap = new HashMap<>(map1);

        for (Map.Entry<K, V> entry : map2.entrySet()) {
            mergedMap.merge(entry.getKey(), entry.getValue(), (v1, v2) -> (V) Integer.valueOf(v1.intValue() + v2.intValue()));
        }

        return mergedMap;
    }
}

public class MergeTwoMaps{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        System.out.println("Enter the number of entries for Map 1: ");
        int n1 = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n1; i++) {
            System.out.println("Enter key (String): ");
            String key = scanner.nextLine();
            System.out.println("Enter value (Integer): ");
            int value = scanner.nextInt();
            scanner.nextLine();
            map1.put(key, value);
        }

        System.out.println("Enter the number of entries for Map 2: ");
        int n2 = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n2; i++) {
            System.out.println("Enter key (String): ");
            String key = scanner.nextLine();
            System.out.println("Enter value (Integer): ");
            int value = scanner.nextInt();
            scanner.nextLine();
            map2.put(key, value);
        }

        scanner.close();

        MapMerger<String, Integer> merger = new MapMerger<>();
        Map<String, Integer> mergedMap = merger.mergeMaps(map1, map2);

        System.out.println("Merged Map: " + mergedMap);
    }
}

