import java.util.*;

public class subArraySumequalstoK {
    public static void main(String[] args) {
        int k = -10;
        int arr[] = { 10, 2, -2, -20, 10 };
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;

        for (int e : arr) {
            sum += e;
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(ans);
    }
}
