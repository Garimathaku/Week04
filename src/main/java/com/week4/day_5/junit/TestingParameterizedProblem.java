package com.week4.day_5.junit;

import java.util.Scanner;

public class TestingParameterizedProblem {
    // Method to check if a number is even
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Main method for manual testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TestingParameterizedProblem tester = new TestingParameterizedProblem();

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        if (tester.isEven(num)) {
            System.out.println(num + " is even.");
        } else {
            System.out.println(num + " is odd.");
        }

        scanner.close();
    }
}

