import java.util.*;

public class queueCollectionFramework {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        System.out.println(q.peek());
        q.poll();  // Safe way to remove (returns null if queue is empty)
        q.poll();
        
        q.add(0);
        q.add(1);
        q.poll();
        q.poll();
        q.poll();
        
        q.add(1);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        
        System.out.println(q.peek());
        q.remove();  // Removes 1
        
        System.out.println();
        
        // Printing all elements until queue is empty
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
