import java.util.*;

public class Itenerary {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Chennai", "Bengaluru");
        map.put("Mumbai", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");

        String start = null;

        for (String city : map.keySet()) {
            if (!map.containsValue(city)) {
                start = city;
                break;
            }
        }

        while (start != null) {
            System.out.print(start);
            start = map.get(start);
            if (start != null) {
                System.out.print(" -> ");
            }
        }
    }
}