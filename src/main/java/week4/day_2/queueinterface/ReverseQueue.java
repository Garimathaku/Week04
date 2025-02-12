package week4.day_2.queueinterface;

import java.util.*;


class QueueReverser<T> {

    // Method to reverse the queue
    public Queue<T> reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<>();

        //  Dequeue all elements from the queue and push them onto the stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Pop all elements from the stack and enqueue them back into the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        return queue;
    }
}

// Main class
public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);

        QueueReverser<Integer> reverser = new QueueReverser<>();
        Queue<Integer> reversedQueue = reverser.reverseQueue(queue);

        System.out.println("Reversed Queue: " + reversedQueue);
    }
}


