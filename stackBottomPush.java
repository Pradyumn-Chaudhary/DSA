import java.util.*; 

public class stackBottomPush {

    //push element to the bottom of stack
    public static void BottomPush(int data, Stack<Integer> s) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        BottomPush(data, s);
        s.push(top);
    }

    //reverse Stack
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        BottomPush(top, s);
    }
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        BottomPush(5, s);
        reverseStack(s);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
        }
    }
