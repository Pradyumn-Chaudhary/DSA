public class Linked_List {
    Node head;
    private int size;

    Linked_List() {
        this.size = 0;
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    //add-first
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    //add-last
    public void addLast(String data) {
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
        size--;
        head = head.next;
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
        Node secondlastNode = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondlastNode = secondlastNode.next;
        }
        secondlastNode.next = null;
    }

    //get size of linked list
    public int getsize() {
        return size;
    }
    public static void main(String args[]) {
        Linked_List list = new Linked_List();
        list.addFirst("2");
        list.printList();
        list.addFirst("1");
        list.printList();
        list.addLast("3");
        list.printList();
        list.deleteFirst();
        list.printList();
        list.deleteLast();
        list.printList();

        System.out.println(list.getsize());
    }
}
