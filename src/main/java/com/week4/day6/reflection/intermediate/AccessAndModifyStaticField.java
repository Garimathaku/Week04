package com.week4.day6.reflection.intermediate;

import java.lang.reflect.*;

class Configuration {
    private static String API_KEY = "Initial_API_KEY";
}

public class AccessAndModifyStaticField {
    public static void main(String[] args) {
        try {
            // Access the Configuration class and the static field API_KEY
            Field field = Configuration.class.getDeclaredField("API_KEY");
            field.setAccessible(true); // Allow access to private static field

            // Modify the static field value
            field.set(null, "New_API_KEY");

            // Print the modified value
            System.out.println("Modified API_KEY: " + field.get(null));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

