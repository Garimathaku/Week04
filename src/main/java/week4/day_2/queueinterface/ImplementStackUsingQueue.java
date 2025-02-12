package week4.day_2.queueinterface;

import java.util.*;

class StackUsingQueues<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    // Constructor
    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push element onto stack
    public void push(T element) {
        queue1.add(element);
    }

    // Pop element from stack
    public T pop() {
        if (queue1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        // Move elements except the last one to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // The last added element is the top of the stack
        T topElement = queue1.remove();

        // Swap queue1 and queue2
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Get the top element without removing it
    public T top() {
        if (queue1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        // Move elements except the last one to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // Get the last added element
        T topElement = queue1.peek();
        queue2.add(queue1.remove());

        // Swap queue1 and queue2
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}

// Main class to test the stack implementation
public class ImplementStackUsingQueue {
    public static void main(String[] args) {
        StackUsingQueues<Integer> stack = new StackUsingQueues<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top Element: " + stack.top());
        System.out.println("Popped Element: " + stack.pop());
        System.out.println("Top Element after Pop: " + stack.top());
    }
}

