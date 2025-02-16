package com.week4.day6.annotation.intermediate;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

// Class using the annotation
class PerformanceTest {
    @LogExecutionTime
    public void fastMethod() {
        long start = System.nanoTime();
        System.out.println("Executing fast method...");
        long end = System.nanoTime();
        System.out.println("Execution Time: " + (end - start) + " ns");
    }

    @LogExecutionTime
    public void slowMethod() {
        long start = System.nanoTime();
        System.out.println("Executing slow method...");
        try {
            Thread.sleep(500); // Simulating delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("Execution Time: " + (end - start) + " ns");
    }
}

// Main class to invoke methods and measure execution time
public class CreateAnnotationForLoggingMethod{
    public static void main(String[] args) throws Exception {
        PerformanceTest test = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                method.invoke(test);
            }
        }
    }
}

