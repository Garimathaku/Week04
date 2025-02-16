package com.week4.day6.reflection.basic;

import java.lang.reflect.*;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student name: " + name);
    }
}

public class DynamicallyCreateObject {
    public static void main(String[] args) {
        try {
            // Dynamically create an instance of Student class
            Class<?> studentClass = Class.forName("Student");
            Constructor<?> constructor = studentClass.getConstructor(String.class);
            Object student = constructor.newInstance("Garima");

            // Invoke display method
            Method method = studentClass.getDeclaredMethod("display");
            method.invoke(student);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
