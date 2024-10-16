import java.util.*;

public class Linked_ListCollections {
    public static void main(String args[]) {
        LinkedList<String> list = new LinkedList<>();

        list.addFirst("is");
        list.addFirst("This");
        System.out.println(list);
        list.addLast("a");
        list.add("list");         // by default add to last
        System.out.println(list);

        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " -> ");
        }
        System.out.println("NULL");

        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);

        list.remove(0);
        System.out.println(list);
   } 
}
