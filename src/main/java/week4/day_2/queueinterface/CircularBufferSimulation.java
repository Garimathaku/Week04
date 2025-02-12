package week4.day_2.queueinterface;

import java.util.*;


class CircularBuffer<T> {
    private T[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    // Constructor
    @SuppressWarnings("unchecked")
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    // Insert an element into the buffer
    public void insert(T element) {
        buffer[tail] = element;
        tail = (tail + 1) % capacity;

        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity;
        }
    }

    // Get all elements in the buffer as a list
    public List<T> getBufferContents() {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(buffer[(head + i) % capacity]);
        }
        return result;
    }
}

// Main class to test the circular buffer implementation
public class CircularBufferSimulation {
    public static void main(String[] args) {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);

        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        System.out.println("Buffer Contents: " + buffer.getBufferContents()); // Output: [1, 2, 3]

        buffer.insert(4);
        System.out.println("Buffer Contents after inserting 4: " + buffer.getBufferContents()); // Output: [2, 3, 4]
    }
}
