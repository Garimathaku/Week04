package week4.day_2.queueinterface;

import java.util.*;


class Patient implements Comparable<Patient> {
    private String name;
    private int severity;

    // Constructor
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // Getters
    public String getName() { return name; }
    public int getSeverity() { return severity; }

    // Compare patients based on severity (higher severity first)
    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity); // Descending order
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

// Generic Hospital Triage System
class HospitalTriage<T extends Patient> {
    private PriorityQueue<T> queue;

    // Constructor
    public HospitalTriage() {
        this.queue = new PriorityQueue<>();
    }

    // Add patient to the queue
    public void addPatient(T patient) {
        queue.add(patient);
    }

    // Treat and remove the highest severity patient
    public T treatPatient() {
        return queue.poll();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

// Main class to test the triage system
public class HospitalTriageSystem {
    public static void main(String[] args) {
        HospitalTriage<Patient> triage = new HospitalTriage<>();

        // Adding patients
        triage.addPatient(new Patient("John", 3));
        triage.addPatient(new Patient("Alice", 5));
        triage.addPatient(new Patient("Bob", 2));

        System.out.println("Treatment Order:");
        while (!triage.isEmpty()) {
            System.out.println(triage.treatPatient());
        }
    }
}

