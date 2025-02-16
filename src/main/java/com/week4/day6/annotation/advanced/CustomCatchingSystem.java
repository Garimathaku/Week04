package com.week4.day6.annotation.advanced;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

// Class with a computationally expensive method
class Calculator {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int expensiveComputation(int number) {
        if (cache.containsKey(number)) {
            System.out.println("Returning cached result for " + number);
            return cache.get(number);
        }
        System.out.println("Computing result for " + number);
        int result = number * number; // Simulated expensive operation
        cache.put(number, result);
        return result;
    }
}

// Main class to test caching
public class CustomCatchingSystem {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();

        Method method = Calculator.class.getMethod("expensiveComputation", int.class);

        if (method.isAnnotationPresent(CacheResult.class)) {
            System.out.println(calculator.expensiveComputation(5));
            System.out.println(calculator.expensiveComputation(5));
            System.out.println(calculator.expensiveComputation(10));
            System.out.println(calculator.expensiveComputation(10));
        }
    }
}

