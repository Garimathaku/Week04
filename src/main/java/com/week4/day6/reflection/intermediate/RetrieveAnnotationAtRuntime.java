package com.week4.day6.reflection.intermediate;


import java.lang.annotation.*;

// Define a custom annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

// Apply the annotation to a class
@Author(name = "XYZ")
class Book {
    // Some class fields and methods
}

public class RetrieveAnnotationAtRuntime{
    public static void main(String[] args) {
        try {
            // Get the class Book
            Class<?> cls = Book.class;

            // Check if the Author annotation is present on the class
            if (cls.isAnnotationPresent(Author.class)) {
                // Retrieve the annotation
                Author author = cls.getAnnotation(Author.class);

                // Display the annotation value
                System.out.println("Author Name: " + author.name());
            } else {
                System.out.println("No Author annotation found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

