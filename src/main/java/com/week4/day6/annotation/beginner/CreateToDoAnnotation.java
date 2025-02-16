package com.week4.day6.annotation.beginner;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

// Class using the annotation
class Project {
    @Todo(task = "Implement user authentication", assignedTo = "Garima", priority = "HIGH")
    public void loginFeature() {
        System.out.println("Login feature pending...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Garima1")
    public void optimizeDB() {
        System.out.println("Database optimization pending...");
    }

    public void completedFeature() {
        System.out.println("This feature is completed.");
    }
}

// Main class to retrieve annotation details
public class CreateToDoAnnotation {
    public static void main(String[] args) {
        Method[] methods = Project.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Task: " + annotation.task());
                System.out.println("Assigned To: " + annotation.assignedTo());
                System.out.println("Priority: " + annotation.priority());

            }
        }
    }
}

