package com.week4.day_3;

import java.io.*;

public class StoreAndRetrievePrimitiveData {
    private static final String FILE_NAME = "src/main/java/com/week4/day_3/Source.txt";

    public static void main(String[] args) {
        // Store student details
        writeStudentData(100, "rtyu", 3.8);
        writeStudentData(300, "tyui", 3.5);

        // Retrieve and display student details
        readStudentData();
    }

    public static void writeStudentData(int rollNumber, String name, double gpa) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME, true))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("Student Details:");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
