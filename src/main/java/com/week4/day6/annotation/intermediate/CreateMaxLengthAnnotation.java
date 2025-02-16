package com.week4.day6.annotation.intermediate;

import java.lang.annotation.*;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// User class with validation
class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        if (username.length() > 10) {
            throw new IllegalArgumentException("Username exceeds maximum length of 10 characters!");
        }
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

// Main class to test validation
public class CreateMaxLengthAnnotation {

    public static void main(String[] args) {
        try {
            User user1 = new User("Garima123"); // Valid
            System.out.println("Valid username: " + user1.getUsername());

            User user2 = new User("LongUsername123"); // Invalid, should throw exception
            System.out.println("Valid username: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

