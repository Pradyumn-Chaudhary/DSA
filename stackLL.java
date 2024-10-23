public class stackLL {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static void pop() {
        if (head == null) {
            System.out.println("Stack Underflow");
            return;
        }
        System.out.println(head.data);
        head = head.next;
    }

    public static void peek() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        System.out.println(head.data);
    }

    public static void traverse() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
    }
    public static void main(String args[]) {
        push(7);
        pop();
        pop();
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        push(6);
        push(7);
        push(8);
        traverse();
        pop();
        peek();
    }
}
