package week4.day_2.setinterface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoSetsAreEquals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read first set
        int n1 = sc.nextInt();
        Set<Integer> set1 = new HashSet<>();
        System.out.println("Enter elements of first set:");
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }

        // Read second set

        int n2 = sc.nextInt();
        Set<Integer> set2 = new HashSet<>();
        System.out.println("Enter elements of second set:");
        for (int i = 0; i < n2; i++) {
            set2.add(sc.nextInt());
        }

        sc.close();

        // Compare sets
        boolean areEqual = areSetsEqual(set1, set2);
        System.out.println("Are both sets equal? " + areEqual);
    }

    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
    }
}
