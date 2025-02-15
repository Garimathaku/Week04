package com.week4.day_5.junit;


import java.util.Scanner;

public class TestingExceptionHandling {
    // Method to perform division, throws ArithmeticException if b is zero
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    // Main method for user interaction
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TestingExceptionHandling calculator = new TestingExceptionHandling();

        System.out.print("Enter numerator: ");
        int num = scanner.nextInt();

        System.out.print("Enter denominator: ");
        int den = scanner.nextInt();

        try {
            int result = calculator.divide(num, den);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

