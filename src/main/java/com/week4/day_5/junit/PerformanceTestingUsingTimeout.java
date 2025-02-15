package com.week4.day_5.junit;


public class PerformanceTestingUsingTimeout {
    // Method that simulates a long-running task (3-second delay)
    public String longRunningTask() {
        try {
            Thread.sleep(3000); // Simulating delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Task Interrupted";
        }
        return "Task Completed";
    }

    // Main method for manual testing
    public static void main(String[] args) {
        PerformanceTestingUsingTimeout tester = new PerformanceTestingUsingTimeout();

        System.out.println("Starting long-running task...");
        String result = tester.longRunningTask();
        System.out.println("Result: " + result);
    }
}

