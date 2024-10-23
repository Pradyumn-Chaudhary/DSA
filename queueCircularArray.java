public class queueCircularArray {
    static int arr[] = new int[5];
    static int front = -1, rear = -1;

    //Enqueue
    public static void Add(int data) {
        if (front == -1 && rear == -1) {
            arr[++rear] = data;
            front++;
        } else if ((rear+1) % 5 == front) {
            System.err.println("Queue Full");
        } else {
            rear = (rear + 1) % 5;
            arr[rear] = data;
        }
    }

    //Dequeue
    public static void Remove() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue Empty");
        } else if (front == rear) {
            System.out.println(arr[front]);
            front = -1;
            rear = -1;
        } else {
            System.out.println(arr[front]);
            front = (front + 1) % 5;
        }
    }

    //Front
    public static void Peek() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue Empty");
        } else {
            System.out.println(arr[front]);
        }
    }

    //Traverse
    public static void Traverse() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue Empty");
            return;
        }
        int temp = front;
        while (true) {
            System.out.println(arr[temp]);
            if (temp == rear) {
                return;
            }
            temp = (temp+1) % 5;
        }
    }

    public static void main(String args[]) {
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
        Add(5);
        Add(5);
        Traverse();
    }
}
