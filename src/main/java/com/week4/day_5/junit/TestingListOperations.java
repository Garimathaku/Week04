package com.week4.day_5.junit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestingListOperations {
    // Add an element to the list
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    // Remove an element from the list
    public boolean removeElement(List<Integer> list, int element) {
        return list.remove(Integer.valueOf(element));
    }

    // Get the size of the list
    public int getSize(List<Integer> list) {
        return list.size();
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TestingListOperations listManager = new TestingListOperations();
        List<Integer> list = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Element");
            System.out.println("2. Remove Element");
            System.out.println("3. Get List Size");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    int addElement = scanner.nextInt();
                    listManager.addElement(list, addElement);
                    System.out.println("Added: " + addElement);
                    break;

                case 2:
                    System.out.print("Enter element to remove: ");
                    int removeElement = scanner.nextInt();
                    if (listManager.removeElement(list, removeElement)) {
                        System.out.println("Removed: " + removeElement);
                    } else {
                        System.out.println("Element not found!");
                    }
                    break;

                case 3:
                    System.out.println("List Size: " + listManager.getSize(list));
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

