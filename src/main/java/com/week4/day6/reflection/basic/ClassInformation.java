package com.week4.day6.reflection.basic;

import java.lang.reflect.*;

public class ClassInformation {
    public static void main(String[] args) {
        try {
            // Accept class name as input
            System.out.print("Enter class name: ");
            String className = new java.util.Scanner(System.in).nextLine();

            // Load the class
            Class<?> cls = Class.forName(className);

            // Displaying Methods
            System.out.println("\nMethods:");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.getName());
            }

            // Displaying Fields
            System.out.println("\nFields:");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getName());
            }

            // Displaying Constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor.getName());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
