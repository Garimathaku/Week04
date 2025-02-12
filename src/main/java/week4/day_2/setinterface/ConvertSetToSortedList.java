package week4.day_2.setinterface;

import java.util.*;

public class ConvertSetToSortedList{
    // Generic method to convert a Set<T> to a sorted List<T>
    public static <T extends Comparable<T>> List<T> convertAndSortSet(Set<T> set) {
        List<T> sortedList = new ArrayList<>(set); // Convert Set to List
        Collections.sort(sortedList); // Sort the List in ascending order
        return sortedList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> numberSet = new HashSet<>();

        System.out.println("Enter numbers (type 'done' to finish):");
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                numberSet.add(sc.nextInt());
            } else if (sc.next().equalsIgnoreCase("done")) {
                break;
            } else {
                System.out.println("Invalid input, please enter an integer or 'done' to finish.");
            }
        }
        sc.close();

        // Converting the Set to a Sorted List
        List<Integer> sortedList = convertAndSortSet(numberSet);

        // Printing the sorted list
        System.out.println("Sorted List: " + sortedList);
    }
}

