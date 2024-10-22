import java.util.*;

public class LLFloyd {

    // Method to check if the linked list contains a cycle
    public Boolean isCyclic() {
        if (head == null) {  // If the list is empty, there can't be a cycle
            return false;
        }

        Node here = head;  // Fast pointer (moves two steps at a time)
        Node turtle = head;  // Slow pointer (moves one step at a time)

        // Traverse the list with two pointers
        while (here.next != null && here.next.next != null) {
            turtle = turtle.next;  // Move the slow pointer by one step
            here = here.next.next;  // Move the fast pointer by two steps

            if (turtle == here) {  // If the two pointers meet, there is a cycle
                return true;
            }
        }
        return false;  // If no cycle is detected, return false
    }

    // Method to remove the cycle from the linked list if present
    public void removeCycle() {
        if (head == null) {  // If the list is empty, nothing to do
            return;
        }

        Node here = head;  // Fast pointer
        Node turtle = head;  // Slow pointer

        // Detect the intersection point where both pointers meet inside the cycle
        while (here.next != null && here.next.next != null) {
            turtle = turtle.next;  // Move slow pointer by one step
            here = here.next.next;  // Move fast pointer by two steps

            if (turtle == here) {  // If pointers meet, cycle is detected
                break;
            }
        }

        // Reset one pointer to head to find the start of the cycle
        turtle = head;
        while (turtle.next != here.next) {  // Move both pointers one step at a time
            here = here.next;
            turtle = turtle.next;
        }

        // Break the cycle by setting the last node's next to null
        here.next = null;
    }

    public static void main(String[] args) {
        // Create a new linked list instance
        LLFloyd list = new LLFloyd();

        // Add elements to the list
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);

        // Introduce a cycle for testing (7 -> 3)
        list.head.next.next.next.next.next.next.next = list.head.next.next;

        // Check if the list is cyclic
        System.out.println("Is list cyclic? " + list.isCyclic());

        // If a cycle is detected, remove it
        if (list.isCyclic()) {
            list.removeCycle();
        }

        // Verify if the cycle is removed
        System.out.println("Is list cyclic after removal? " + list.isCyclic());

        // Print the final list
        list.printList();
    }

    // Node class to represent each element in the linked list
    class Node {
        int data;  // Data part of the node
        Node next; // Pointer to the next node

        // Constructor to initialize a new node with data
        Node(int data) {
            this.data = data;
            this.next = null;
            size++;  // Increment the size of the list
        }
    }

    // Head pointer to the first node of the linked list
    Node head;

    // Variable to store the size of the linked list
    private int size;

    // Constructor to initialize an empty linked list
    LLFloyd() {
        size = 0;
    }

    // Method to add a node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);  // Create a new node
        if (head == null) {  // If the list is empty, set new node as head
            head = newNode;
            return;
        }
        newNode.next = head;  // Link new node to the current head
        head = newNode;  // Update head to the new node
    }

    // Method to add a node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);  // Create a new node
        if (head == null) {  // If the list is empty, set new node as head
            head = newNode;
            return;
        }

        // Traverse to the last node
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        // Link the new node to the last node
        currNode.next = newNode;
    }

    // Method to print the entire list
    public void printList() {
        Node currNode = head;  // Start from the head
        while (currNode != null) {  // Traverse the list
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");  // Indicate the end of the list
    }

    // Method to delete the first node of the list
    public void deleteFirst() {
        if (head == null) {  // If the list is empty, print a message
            System.out.println("List is Empty");
            return;
        }
        head = head.next;  // Update head to the next node
        size--;  // Decrement the size
    }

    // Method to delete the last node of the list
    public void deleteLast() {
        if (head == null) {  // If the list is empty, print a message
            System.out.println("List is Empty");
            return;
        }

        size--;  // Decrement the size
        if (head.next == null) {  // If there's only one node, remove it
            head = null;
            return;
        }

        // Traverse to the second last node
        Node secondLastNode = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            secondLastNode = secondLastNode.next;
            lastNode = lastNode.next;
        }

        // Remove the last node
        secondLastNode.next = null;
    }

    // Method to print the size of the list
    public void getsize() {
        System.out.println("Size of the list: " + size);
    }
}
