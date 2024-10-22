import java.util.*;  // Importing necessary packages

public class LLQ2 {

    // Method to find the middle node of the linked list
    public Node findMiddle(Node head) {
        Node hare = head;  // Fast pointer (moves two steps at a time)
        Node turtle = head;  // Slow pointer (moves one step at a time)
        
        // Loop until the hare reaches the end or its next node is null
        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;  // Hare moves two steps
            turtle = turtle.next;  // Turtle moves one step
        }
        return turtle;  // Return the middle node (where the turtle stopped)
    }

    // Method to reverse the linked list
    public Node reverse(Node head) {
        Node prevNode = null;  // Initially, the previous node is null
        Node currNode = head;  // Start with the head node
        
        // Loop to reverse the pointers of the nodes
        while (currNode != null) {
            Node nextNode = currNode.next;  // Save the next node
            currNode.next = prevNode;  // Reverse the current node's pointer

            prevNode = currNode;  // Move the previous node forward
            currNode = nextNode;  // Move the current node forward
        }
        return prevNode;  // Return the new head of the reversed list
    }

    // Check if the linked list is a palindrome using extra space
    public Boolean isPalindromeX() {
        // If the list is empty or has only one node, it's a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // Create a new reversed list
        LLQ2 reversedList = new LLQ2();
        Node currNode = head;

        // Traverse the original list and add elements to the reversed list
        while (currNode != null) {
            reversedList.addFirst(currNode.data);  // Add to the start for reversed order
            currNode = currNode.next;  // Move to the next node
        }

        // Pointers to compare original and reversed lists
        Node originalNode = head;
        Node reverseListNode = reversedList.head;

        // Compare both lists element by element
        while (originalNode != null && reverseListNode != null) {
            if (originalNode.data != reverseListNode.data) {
                return false;  // If any mismatch, it's not a palindrome
            }
            originalNode = originalNode.next;  // Move in original list
            reverseListNode = reverseListNode.next;  // Move in reversed list
        }

        return true;  // If all elements match, it's a palindrome
    }

    // Optimized palindrome check using two pointers and reversal
    public Boolean isPalindrome() {
        // If list is empty or has only one node, it's a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the list
        Node middle = findMiddle(head);

        // Reverse the second half of the list starting from the middle's next node
        Node secondHalfStart = reverse(middle.next);

        Node firstHalfStart = head;  // Start from the head for comparison

        // Compare the first half and the reversed second half
        while (secondHalfStart != null) {
            if (firstHalfStart.data != secondHalfStart.data) {
                return false;  // If any mismatch, it's not a palindrome
            }
            firstHalfStart = firstHalfStart.next;  // Move in the first half
            secondHalfStart = secondHalfStart.next;  // Move in the reversed half
        }
        return true;  // If all elements match, it's a palindrome
    }

    public static void main(String[] args) {
        LLQ2 list = new LLQ2();  // Create a new linked list

        // Add elements to the list to create a palindrome (0 -> 1 -> 2 -> 1 -> 0)
        list.addFirst(0);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(0);

        // Print the list and its size
        list.printList();
        list.getsize();

        // Check if the list is a palindrome using both methods
        System.out.println(list.isPalindromeX());  // Using extra space
        System.out.println(list.isPalindrome());  // Using optimized approach
    }

    // Node class representing elements in the linked list
    class Node {
        int data;  // Data stored in the node
        Node next;  // Pointer to the next node

        // Constructor to initialize the node with data
        Node(int data) {
            this.data = data;
            this.next = null;  // Initialize next as null
            size++;  // Increase the size of the list
        }
    }

    Node head;  // Head pointer to the first node
    private int size;  // Variable to store the list size

    // Constructor to initialize an empty linked list
    LLQ2() {
        size = 0;  // Initial size is 0
    }

    // Add a node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);  // Create a new node
        if (head == null) {  // If list is empty, set new node as head
            head = newNode;
            return;
        }
        newNode.next = head;  // Point new node to current head
        head = newNode;  // Update head to new node
    }

    // Add a node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);  // Create a new node
        if (head == null) {  // If list is empty, set new node as head
            head = newNode;
            return;
        }
        Node currNode = head;  // Start from the head
        while (currNode.next != null) {  // Traverse to the last node
            currNode = currNode.next;
        }
        currNode.next = newNode;  // Link last node to new node
    }

    // Print the entire list
    public void printList() {
        Node currNode = head;  // Start from the head
        while (currNode != null) {  // Traverse until the end
            System.out.print(currNode.data + " -> ");  // Print data of each node
            currNode = currNode.next;  // Move to the next node
        }
        System.out.println("NULL");  // Indicate end of the list
    }

    // Delete the first node of the list
    public void deleteFirst() {
        if (head == null) {  // If list is empty, print a message
            System.out.println("List is Empty");
            return;
        }
        head = head.next;  // Update head to the next node
        size--;  // Decrement the size
    }

    // Delete the last node of the list
    public void deleteLast() {
        if (head == null) {  // If list is empty, print a message
            System.out.println("List is Empty");
            return;
        }
        size--;  // Decrement size
        if (head.next == null) {  // If only one node, remove it
            head = null;
            return;
        }
        Node secondLastNode = head;  // Start from head
        Node LastNode = head.next;  // Pointer to the next node
        while (LastNode.next != null) {  // Traverse to second last node
            secondLastNode = secondLastNode.next;
            LastNode = LastNode.next;
        }
        secondLastNode.next = null;  // Remove last node
    }

    // Print the size of the list
    public void getsize() {
        System.out.println(size);  // Print current size
    }
}
