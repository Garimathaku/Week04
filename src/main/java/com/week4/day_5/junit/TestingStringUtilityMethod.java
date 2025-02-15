package com.week4.day_5.junit;


import java.util.Scanner;

public class TestingStringUtilityMethod {
    // Reverse a given string
    public static String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    // Check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        return str.equalsIgnoreCase(reverse(str));
    }

    // Convert string to uppercase
    public static String toUpperCase(String str) {
        if (str == null) return null;
        return str.toUpperCase();
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TestingStringUtilityMethod stringUtils = new TestingStringUtilityMethod();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Reversed String: " + TestingStringUtilityMethod.reverse(input));
        System.out.println("Is Palindrome? " + TestingStringUtilityMethod.isPalindrome(input));
        System.out.println("Uppercase String: " + TestingStringUtilityMethod.toUpperCase(input));

        scanner.close();
    }
}
