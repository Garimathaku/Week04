package week4.day_2.setinterface;

import java.util.*;

public class SymmetricDifference {
    // Generic method to find symmetric difference of two sets
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        // Copy set1 to result
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        result.removeAll(intersection);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for first set

        Set<Integer> set1 = new HashSet<>();
        for (String s : sc.nextLine().split(",")) {
            set1.add(Integer.parseInt(s.trim()));
        }

        // Taking input for second set

        Set<Integer> set2 = new HashSet<>();
        for (String s : sc.nextLine().split(",")) {
            set2.add(Integer.parseInt(s.trim()));
        }

        // Displaying the symmetric difference
        System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2));

        sc.close();
    }
}

