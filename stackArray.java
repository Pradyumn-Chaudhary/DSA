public class stackArray {
    // 'top' keeps track of the current index of the topmost element in the stack.
    int top = -1; 
    // Array to store the stack elements, with a fixed size of 7.
    int arr[] = new int[7]; 

    // Method to add (push) an element onto the stack.
    public void push(int x) {
        // Check if the stack is full (top points to the last index).
        if (top == arr.length - 1) { 
            System.err.println("Stack Overflow"); // Print overflow message if stack is full.
        } else {
            arr[++top] = x; // Increment 'top' and place the new element at that position.
        }
    }
    
    // Method to remove (pop) the topmost element from the stack.
    public void pop() {
        // Check if the stack is empty (no elements to pop).
        if (top == -1) {
            System.out.println("Stack Underflow"); // Print underflow message if stack is empty.
        } else {
            // Print the popped element and decrement 'top'.
            System.out.println(arr[top--]);
        }
    }

    // Method to view the topmost element without removing it.
    public void peek() {
        // Check if the stack is empty.
        if (top == -1) {
            System.out.println("Empty Stack"); // Print message if the stack is empty.
            return; // Exit to avoid accessing invalid index.
        }
        // Print the topmost element.
        System.out.println(arr[top]);
    }

    // Method to display all elements in the stack from bottom to top.
    public void traverse() {
        // Check if there are elements to print.
        if (top == -1) {
            System.out.println("Stack is Empty"); // Handle empty stack case.
            return;
        }
        // Iterate from the bottom (index 0) to the top.
        int i = 0;
        while (i <= top) {
            System.out.println(arr[i]); // Print each element.
            i++;
        }
    }

    // Main method: Entry point of the program.
    public static void main(String args[]) {
        // Create a new stack instance.
        stackArray stack = new stackArray();
        
        // Push the value 7 onto the stack.
        stack.push(7);  
        
        // Pop the top element (7) and print it.
        stack.pop();  
        
        // Try to pop again; prints "Stack Underflow" since the stack is now empty.
        stack.pop();  
        
        // Push multiple values onto the stack.
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);  // Stack is now full (7 elements).
        
        // Attempt to push another element (8); prints "Stack Overflow".
        stack.push(8);  
        
        // Traverse and print all elements currently in the stack.
        stack.traverse(); 
        
        // Pop the top element (7) and print it.
        stack.pop(); 
        
        // Peek at the new top element (6) without removing it.
        stack.peek();  
    }
}
