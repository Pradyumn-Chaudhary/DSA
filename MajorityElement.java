import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int nums[] = { 1, 2, 1, 3, 5, 1, 2, 5, 1 };

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        // for (Map.Entry<Integer, Integer> e : map.entrySet()) {
        //     if (e.getValue() > nums.length / 3) {
        //         System.out.println(e.getKey());
        //     }
        // }

        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 3) {
                System.out.println(key);
            }
        }

        /*  HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        
        int nums[] = { 1, 2, 1, 3, 5, 1, 2, 5, 1 };
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > nums.length / 3) {
                set.add(nums[i]);
            }
        }
        
        // if (nums.length <= 3) {
        //     for (int val : nums) {
        //         set.add(val);
        //     }
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     if (!map.containsKey(nums[i])) {
        //         map.put(nums[i], 1);
        //     } else {
        //         int val = map.get(nums[i]);
        //         map.put(nums[i], val + 1);
        //         val = map.get(nums[i]);
        //         if (val > nums.length / 3) {
        //             set.add(nums[i]);
        //         }
        //     }
        // }
        
        System.out.println(set); */
    }
}
