import java.util.ArrayList; //import java.util.*;
import java.util.Collections;

public class Arraylist {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();

        //add elements
        list.add(0);
        list.add(1);
        list.add(23);
        System.out.println(list);

        //get elements
        int element = list.get(0);
        System.out.println(element);
        System.out.println(list.get(1));

        //add element in between
        list.add(1, 20);
        System.out.println(list);

        //set element
        list.set(3, 2);
        System.out.println(list);

        //delete element
        list.remove(2);
        System.out.println(list);

        //size
        System.out.println(list.size());

        //loop
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //sorting
        Collections.sort(list);
        System.out.println(list);
    }
}
