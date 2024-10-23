import java.util.*; // Importing Java's built-in collection framework

public class stackCollectionFramework {
    public static void main(String args[]) {
        // Creating a Stack of integers
        Stack<Integer> s = new Stack<>();

        // Push 7 onto the stack
        s.push(7);

        // Check if the stack is not empty before peeking and popping
        if (!s.isEmpty()) {
            System.out.println("Popped: " + s.peek()); // Print the top element
            s.pop(); // Remove the top element from the stack
        } else {
            System.out.println("Stack Underflow"); // Handle case when stack is empty
        }

        // Attempt to pop another element
        if (!s.isEmpty()) {
            System.out.println("Popped: " + s.peek()); // Print the top element
            s.pop(); // Remove the top element
        } else {
            System.out.println("Stack Underflow"); // Handle stack underflow
        }

        // Pushing multiple elements onto the stack
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(7);

        // Displaying all elements as they are popped from the stack
        System.out.println("Stack Elements:");
        while (!s.isEmpty()) {
            System.out.println("Popped: " + s.peek()); // Print the top element
            s.pop(); // Remove the top element
        }
    }
}
