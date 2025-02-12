package week4.day_2.listinterface;

import java.util.*;

public class NthElementFromEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get list size from user
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        LinkedList<String> list = new LinkedList<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        // Get N value from user
        System.out.print("Enter the position (N) from the end: ");
        int N = sc.nextInt();
        sc.close();

        // Find and display the Nth element from the end
        String result = findNthFromEnd(list, N);
        System.out.println("The " + N + "th element from the end is: " + result);
    }


    public static <T> T findNthFromEnd(LinkedList<T> list, int N) {
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();

        // Move first pointer N steps ahead
        for (int i = 0; i < N; i++) {
            if (!first.hasNext()) {
                throw new IllegalArgumentException("N is larger than the list size");
            }
            first.next();
        }

        // Move both pointers until first reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next();
    }
}
