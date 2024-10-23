public class queueLL {
    static Node front = null;
    static Node rear = null;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //check Empty
    public static Boolean isEmpty() {
        if (rear == null && front == null) {
            return true;
        }
        return false;
    }

    //Enqueue
    public static void Add(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    //Dequeue
    public static void Remove() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else if (front == rear) {
            System.out.println(front.data);
            front = null;
            rear = null;
        } else {
            System.out.println(front.data);
            front = front.next;
        }
    }

    //Front
    public static void Peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println(front.data);
        }
    }

    //Traverse
    public static void Traverse() {
        Node currNode = front;
        while (currNode != null) {
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        Add(0);
        Peek();
        Remove();
        Remove();
        Add(0);
        Add(1);
        Remove();
        Remove();
        Remove();
        Add(1);
        Add(1);
        Add(2);
        Add(3);
        Add(4);
        Add(5);
        Peek();
        Remove();
        Traverse();
    }
}
