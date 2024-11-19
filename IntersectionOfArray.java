import java.util.*;

public class IntersectionOfArray{
    public static void main(String[] args) {
        int nums1[] = { 7, 3, 9 };
        int nums2[] = { 6, 3, 9, 6, 2, 4 };

    HashSet<Integer> set1 = new HashSet<>();
    HashSet<Integer> set2 = new HashSet<>();

    for (int i = 0; i < nums1.length; i++) {
        set1.add(nums1[i]);
    }
    for (int i = 0; i < nums2.length; i++) {
        if (set1.contains(nums2[i])) {
            set2.add(nums2[i]);
        }
    }
    System.out.println(set2);
    System.out.println(set2.size());
}
}