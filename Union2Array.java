import java.util.*;

public class Union2Array {
    public static void main(String[] args) {
        int nums1[] = { 7, 3, 9 };
        int nums2[] = { 6, 3, 9, 6, 2, 4 };

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }
        System.out.println(set);
        System.out.println(set.size());
    }
}
