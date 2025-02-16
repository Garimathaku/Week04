package com.week4.day6.annotation.beginner;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

// Class using the annotation
class CriticalOperations {
    @ImportantMethod(level = "HIGH")
    public void processTransaction() {
        System.out.println("Processing a critical transaction...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void generateReport() {
        System.out.println("Generating a report");
    }

    public void normalOperation() {
        System.out.println("This is a normal operation");
    }
}

// Main class to retrieve annotation details
public class CreateAnnotationToMarkMethods {
    public static void main(String[] args) {
        Method[] methods = CriticalOperations.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Importance Level: " + annotation.level());
            }
        }
    }
}

