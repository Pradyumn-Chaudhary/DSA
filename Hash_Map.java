import java.util.*;
//import java.util.HashMap;

public class Hash_Map {
    public static void main(String[] args) {
        //country(key),population(value);
        HashMap<String, Integer> map = new HashMap<>();
        
        //insertion
        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);

        //print HashMap
        System.out.println(map);

        //update value
        map.put("India", 150);
        map.put("China", 100);
        System.out.println(map);

        //search
        if (map.containsKey("US")) {
            System.out.println("Key is present in tha Map");
        } else {
            System.out.println("Key is not present in the map");
        }

        if (map.containsKey("Indonesia")) {
            System.out.println("Key is present in tha Map");
        } else {
            System.out.println("Key is not present in the map");
        }

        System.out.println(map.get("China"));       //key exist
        System.out.println(map.get("Indonesia")); //key doesn't exist
        
        //iteration in HashMap
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
        System.out.println();
       
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " -> " + map.get(key));
        }

        System.out.println(map);
        //remove
        map.remove("China");
        System.out.println(map);
    }
}
