package week4.day_2.listinterface;

import java.util.*;

public class ReverseAList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         //take input from the user
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            arrayList.add(element);
            linkedList.add(element);
        }

        scanner.close();

        System.out.println("Original ArrayList: " + arrayList);
        System.out.println("Original LinkedList: " + linkedList);
        //call the methods
        reverseList(arrayList);
        reverseList(linkedList);

        System.out.println("Reversed ArrayList: " + arrayList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }

    // Method to reverse a list manually
    public static <T> void reverseList(List<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
}
