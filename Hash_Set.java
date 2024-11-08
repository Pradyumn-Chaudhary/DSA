import java.util.HashSet;
import java.util.Iterator;

public class Hash_Set {
    public static void main(String[] args) {
        //creating
        HashSet<Integer> set = new HashSet<>();
        
        //insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1); //list.add(el)

        //size
        System.out.println("size of set is : " + set.size());

        //search -> contains
        if (set.contains(1)) {
            System.out.println("set contains 1");
        } else {
            System.out.println("does not contain 1");
        }

        if (set.contains(6)) {
            System.out.println("set contains 6");
        } else {
            System.out.println("does not contain 6");
        }

        //delete
        set.remove(1);
        if (!set.contains(1)) {
            System.out.println("1 removed from set");
        }

        System.out.println("size of set is : " + set.size());

        //print all elements
        System.out.println(set);

        //iterator
        Iterator it = set.iterator();
        //hashnext: next
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
