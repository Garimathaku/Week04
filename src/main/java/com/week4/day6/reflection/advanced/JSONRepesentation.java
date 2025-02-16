package com.week4.day6.reflection.advanced;


import java.lang.reflect.*;

public class JSONRepesentation {

    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");

        try {
            // Get all fields of the class
            Field[] fields = obj.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true); // Make private fields accessible

                // Append field name and value in JSON format
                json.append("\"").append(fields[i].getName()).append("\": ")
                        .append("\"").append(fields[i].get(obj)).append("\"");

                if (i < fields.length - 1) {
                    json.append(", ");
                }
            }

            json.append("}");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return json.toString();
    }

    public static void main(String[] args) {
        // Sample class
        class Person {
            private String name;
            private int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }

        Person person = new Person("abc", 25);
        String json = toJson(person);
        System.out.println(json);
    }
}

