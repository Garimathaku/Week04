package week4.day_2.listinterface;


import java.util.*;

public class RotateElementInList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get list size from user

        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // Get rotation count
        System.out.print("Enter the number of positions to rotate: ");
        int k = sc.nextInt();
        sc.close();


        rotateList(list, k);

        // Display result
        System.out.println("Rotated List: " + list);
    }


    public static void rotateList(List<Integer> list, int k) {
        int n = list.size();
        k = k % n;
        if (k == 0) return;

        List<Integer> temp = new ArrayList<>(list.subList(k, n));
        temp.addAll(list.subList(0, k));

        list.clear();
        list.addAll(temp);
    }
}

