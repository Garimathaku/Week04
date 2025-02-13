package com.week4.day_3;

import java.io.*;
//class WriterThread extends class Thread
class WriterThread extends Thread {
    private PipedOutputStream outputStream;
//constructor
    public WriterThread(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            String message = "Hello ,welcome to the world of programming";
            System.out.println("Writer");
            outputStream.write(message.getBytes()); // Write data to the pipe
            outputStream.close(); // Close the stream after writing
        } catch (IOException e) {
            System.err.println("Writer Error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream inputStream;
//constructor
    public ReaderThread(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            System.out.println("Reader");
            int data;
            while ((data = inputStream.read()) != -1) { // Read data from pipe
                System.out.print((char) data);
            }
            System.out.println("\nDone");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
//Main class
public class InterThreadCommunication {
    public static void main(String[] args) {
        try {
            PipedOutputStream outputStream = new PipedOutputStream();
            PipedInputStream inputStream = new PipedInputStream(outputStream); // Connect pipes

            // Create threads
            Thread writer = new WriterThread(outputStream);
            Thread reader = new ReaderThread(inputStream);

            // Start threads
            writer.start();
            reader.start();

            // Wait for both threads to complete
            writer.join();
            reader.join();

        } catch (IOException | InterruptedException e) {
            System.err.println("Main Thread Error: " + e.getMessage());
        }
    }
}

