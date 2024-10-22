import java.util.*;

public class LLQ1 {
    Node head;
    private int size;

    LLQ1() {
        size = 0;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    //add first 
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    //add last
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    //print list
    public void printList() {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    //delete first
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        head = head.next;
        size--;
    }

    //delete last
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        size--;
        if (head.next == null) {
            head = null;
            return;
        }
        Node secondLastNode = head;
        Node LastNode = head.next;
        while (LastNode.next != null) {
            secondLastNode = secondLastNode.next;
            LastNode = LastNode.next;
        }
        secondLastNode.next = null;
    }

    //get size of LL
    public void getsize() {
        System.out.println(size);
    }

    //access n node from last
    public void nthNode(int n) {
        int dfs = size - n + 1;
        Node currNode = head;
        for (int i = 1; i < dfs; i++) {
            currNode = currNode.next;
        }
        System.out.println(currNode.data);
    }

    //delete nth node from last
    public void deleteNthLast(int n) {
        int dfspn = size - n;
        Node currNode = head;
        size--;
        if (n == size) {
            head = head.next;
            printList();
            return;
        }
        for (int i = 1; i < dfspn; i++) {
            currNode = currNode.next;
        }
        currNode.next = currNode.next.next;
        printList();
    }
    public static void main(String[] args) {
        LLQ1 list = new LLQ1();
        list.addFirst(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(0);
        list.printList();
        list.getsize();
        list.deleteFirst();
        list.printList();
        list.deleteLast();
        list.printList();
        list.getsize();

        list.nthNode(4);
        
        list.deleteNthLast(2);
        list.getsize();
    }
}
