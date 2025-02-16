package com.week4.day6.reflection.intermediate;


import java.lang.reflect.*;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        try {
            // Create an instance of MathOperations
            MathOperations mathOps = new MathOperations();

            // Take user input for method selection
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation (add, subtract, multiply): ");
            String operation = scanner.nextLine();

            // Get the Method object for the user-selected method
            Method method = MathOperations.class.getDeclaredMethod(operation, int.class, int.class);

            // Take user input for the parameters
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Invoke the selected method
            Object result = method.invoke(mathOps, num1, num2);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

