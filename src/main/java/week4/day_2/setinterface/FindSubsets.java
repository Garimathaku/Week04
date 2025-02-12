package week4.day_2.setinterface;

import java.util.*;

public class FindSubsets {
    // Generic method to check if set1 is a subset of set2
    public static <T> boolean isSubset(Set<T> set1, Set<T> set2) {
        return set2.containsAll(set1); // Returns true if set2 contains all elements of set1
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for the first set
        Set<Integer> set1 = new HashSet<>();
        System.out.println("Enter elements of Set1 (type 'done' to finish):");
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                set1.add(sc.nextInt());
            } else if (sc.next().equalsIgnoreCase("done")) {
                break;
            } else {
                System.out.println("Invalid input, please enter an integer or 'done' to finish.");
            }
        }

        // Taking input for the second set
        Set<Integer> set2 = new HashSet<>();
        System.out.println("Enter elements of Set2 (type 'done' to finish):");
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                set2.add(sc.nextInt());
            } else if (sc.next().equalsIgnoreCase("done")) {
                break;
            } else {
                System.out.println("Invalid input, please enter an integer or 'done' to finish.");
            }
        }
        sc.close();

        // Checking if Set1 is a subset of Set2
        boolean result = isSubset(set1, set2);
        System.out.println("Is Set1 a subset of Set2? " + result);
    }
}

