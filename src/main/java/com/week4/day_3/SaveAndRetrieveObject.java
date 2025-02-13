package com.week4.day_3;

import java.io.*;
import java.util.*;
//class Employee implements Serializable interface
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;
   //constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{ID=" + id + ", Name='" + name + "', Department='" + department + "', Salary=" + salary + '}';
    }
}
//Main class
public class SaveAndRetrieveObject {
    private static final String FILE_NAME = "src/main/java/com/week4/day_3/Source.txt";

    public static void main(String[] args) {
        //create a list to store employee details
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "xyz", "IT", 90000));
        employees.add(new Employee(2, "abc", "HR", 65000));
        employees.add(new Employee(3, "pqr", "Finance", 10000));

        serializeEmployees(employees);
        List<Employee> deserializedEmployees = deserializeEmployees();

        System.out.println("Deserialized Employees:");
        for (Employee emp : deserializedEmployees) {
            System.out.println(emp);
        }
    }

    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }
    }

    private static List<Employee> deserializeEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
