package com.week4.day4;

import java.util.Scanner;
public class NestedTryCatchBlock  {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {5, 20, 35, 50};
          //take index input from the user
        System.out.print("Enter index to access: ");
        int index = sc.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();

        try {
            // Outer try block for array access
            int value = arr[index];

            try {
                // Inner try block for division
                int result = value / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } finally {
            System.out.println("Operation completed.");
        }


    }
}
