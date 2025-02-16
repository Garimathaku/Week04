package com.week4.day6.reflection.advanced;


import java.lang.reflect.*;

public class MethodExecutionTime {

    public static void measureExecutionTime(Object obj, String methodName, Class<?>[] parameterTypes, Object[] args) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName, parameterTypes);

        long startTime = System.nanoTime();

        // Invoke the method
        method.setAccessible(true);
        method.invoke(obj, args);

        long endTime = System.nanoTime();

        System.out.println("Execution time of method " + methodName + ": " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        class Calculator {
            public void add(int a, int b) {
                System.out.println("Addition Result: " + (a + b));
            }
        }

        try {
            Calculator calculator = new Calculator();
            measureExecutionTime(calculator, "add", new Class<?>[] { int.class, int.class }, new Object[] { 10, 20 });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

