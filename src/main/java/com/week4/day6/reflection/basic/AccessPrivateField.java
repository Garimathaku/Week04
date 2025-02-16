package com.week4.day6.reflection.basic;

import java.lang.reflect.*;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }
}

public class AccessPrivateField {
    public static void main(String[] args) {
        try {
            // Create an instance of Person
            Person person = new Person(25);

            // Access private field 'age' using reflection
            Field field = Person.class.getDeclaredField("age");
            field.setAccessible(true); // Allow access to private field

            // Retrieve value of private field
            System.out.println("Age before modification: " + field.get(person));

            // Modify the value of the private field
            field.set(person, 30);
            System.out.println("Age after modification: " + field.get(person));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
