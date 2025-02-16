package com.week4.day6.annotation.exercise;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

// Class using the annotation
class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Garima")
    public void completeTask() {
        System.out.println("Task completed!");
    }
}

// Main class to retrieve annotation details
public class CreateCustomAnnotation {
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("completeTask");
        TaskInfo annotation = method.getAnnotation(TaskInfo.class);

        if (annotation != null) {
            System.out.println("Priority: " + annotation.priority());
            System.out.println("Assigned To: " + annotation.assignedTo());
        }
    }
}

