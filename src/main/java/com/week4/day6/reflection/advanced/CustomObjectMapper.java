package com.week4.day6.reflection.advanced;

import java.lang.reflect.*;
import java.util.*;

public class CustomObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        // Create an instance of the target class
        T instance = clazz.getDeclaredConstructor().newInstance();

        // Iterate over the properties and set field values using reflection
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String fieldName = entry.getKey();
            Object fieldValue = entry.getValue();

            try {
                // Get the field by name and make it accessible
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);

                // Set the field value in the object
                field.set(instance, fieldValue);
            } catch (NoSuchFieldException e) {
                System.out.println("Field not found: " + fieldName);
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        try {
            // Sample class to map properties to
            class Person {
                private String name;
                private int age;

                @Override
                public String toString() {
                    return "Person{name='" + name + "', age=" + age + '}';
                }
            }

            // Create a Map of properties
            Map<String, Object> properties = new HashMap<>();
            properties.put("name", "John");
            properties.put("age", 30);

            // Use the custom object mapper to create an instance
            Person person = toObject(Person.class, properties);
            System.out.println(person);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
