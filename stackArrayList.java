import java.util.*;

public class stackArrayList {
    static ArrayList<Integer> stack = new ArrayList<>();
    static int top = -1;

    public static void push(int x) {
        stack.add(x);
        top++;
    }

    public static void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(stack.get(top));
            stack.remove(top--);
        }
    }

    public static void peek() {
        if (top == -1) {
            System.out.println("Empty");
        } else {
            System.out.println(stack.get(top));
        }
    }

    public static void traverse() {
        if (top == -1) {
            System.out.println("Empty");
        } else {
            int i = 0;
            while (i <= top) {
                System.out.println(stack.get(i));
                i++;
            }
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
