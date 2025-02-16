package com.week4.day6.annotation.advanced;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

// User class to simulate roles
class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// Service class with restricted methods
class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed!");
    }

    @RoleAllowed("USER")
    public void userTask() {
        System.out.println("User task executed!");
    }
}

// Main class to check role and invoke method
public class RoleAllowedAnnotation {
    public static void main(String[] args) throws Exception {
        User currentUser = new User("USER"); // Change to "ADMIN" to test access

        SecureService service = new SecureService();
        Method[] methods = SecureService.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed annotation = method.getAnnotation(RoleAllowed.class);
                if (annotation.value().equals(currentUser.getRole())) {
                    method.invoke(service);
                } else {
                    System.out.println("Access Denied! You need " + annotation.value() + " role.");
                }
            }
        }
    }
}

