package com.week4.day6.annotation.advanced;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

// User class with annotated fields
class Users {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public Users(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

// JSON serializer
class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        Map<String, String> jsonMap = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                jsonMap.put(annotation.name(), field.get(obj).toString());
            }
        }
        return jsonMap.toString().replace("=", ":");
    }
}

// Main class to test serialization
public class CustomSerializationAnnotation {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("Garima");
        String jsonString = JsonSerializer.toJson(user);
        System.out.println(jsonString);
    }
}

