package com.week4.day_5.junit;

public class TestingBeforeEachAndAfterEachAnnotations {
    private boolean isConnected;

    // Method to simulate connecting to a database
    public void connect() {
        isConnected = true;
        System.out.println("Database Connected.");
    }

    // Method to simulate disconnecting from a database
    public void disconnect() {
        isConnected = false;
        System.out.println("Database Disconnected.");
    }

    // Method to check if connection is active
    public boolean isConnected() {
        return isConnected;
    }

    // Main method for testing manually
    public static void main(String[] args) {
        TestingBeforeEachAndAfterEachAnnotations db = new TestingBeforeEachAndAfterEachAnnotations();

        db.connect();
        System.out.println("Connection Status: " + db.isConnected());

        db.disconnect();
        System.out.println("Connection Status: " + db.isConnected());
    }
}

