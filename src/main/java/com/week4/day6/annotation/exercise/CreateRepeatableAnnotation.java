package com.week4.day6.annotation.exercise;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

// Container annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Class using the annotation
class Software {
    @BugReport(description = "Fix NullPointerException")
    @BugReport(description = "Improve performance on large datasets")
    public void processData() {
        System.out.println("Processing data...");
    }
}

// Main class to retrieve annotation details
public class CreateRepeatableAnnotation {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("processData");
        BugReports bugReports = method.getAnnotation(BugReports.class);

        if (bugReports != null) {
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug: " + bug.description());
            }
        }
    }
}

