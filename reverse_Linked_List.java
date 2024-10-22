import java.util.*;

public class reverse_Linked_List {

    Node head;
    private int size;

    reverse_Linked_List() {
        this.size = 0;
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
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
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
        Node lastNode = head.next;
        while (lastNode.next != null) {
            secondLastNode = lastNode;
            lastNode = lastNode.next;
        }
        secondLastNode.next = null;
    }

    //get size of LinkedList
    public void getsize() {
        System.out.println("size of LinkedList is" + size);
    }

    //reverse iterate
    public void reverseIterate() {

        if (head == null || head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;

        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            //update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    //reverse recursive
    public Node reverseRecersive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newhead = reverseRecersive(head.next);
        head.next.next = head;
        head.next = null;

        return newhead;
    }
    public static void main(String args[]) {
        reverse_Linked_List list = new reverse_Linked_List();
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.printList();
        list.reverseIterate();
        list.printList();
        list.head = list.reverseRecersive(list.head);
        list.printList();
    }
}









// //reverse by taking extra space
    // public void reverseBoot(reverse_Linked_List list) {
    //     reverse_Linked_List reversedlist = new reverse_Linked_List();
    //     for (int i = list.size() - 1; i >= 0; i--) {
    //         reversedlist.add(list.get(i));
    //     }
    //     list.clear();//clear original list
    //     list.addAll(reversedlist); //add element from reversed list
    // }
