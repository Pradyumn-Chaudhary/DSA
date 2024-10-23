import java.util.*;

public class queue2Stacks1 {
    static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public Boolean isEmpty() {
            return s1.isEmpty();
        }

        public void add(int data) {
            s1.push(data);
        }

        public void remove() {
            if (s1.isEmpty()) {
                System.out.println("Queue is Empty");
                return;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            System.out.println(s2.peek());
            s2.pop();
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public void peek() {
            if (s1.isEmpty()) {
                System.out.println("Queue is Empty");
                return;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            System.out.println(s2.peek());
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue();
        q.add(1);
        q.remove();
        q.remove();
        q.add(5);
        q.peek();
        q.add(7);
        q.add(11);
        q.add(17);

        while (!q.isEmpty()) {
            q.remove();
        }
    }
}
