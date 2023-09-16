package leetcode.slideWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class IsContainsDuplicateElements {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        List<Integer> set = new ArrayList<>(k); // define the slide window size.
        for (int i = 0; i < nums.length; i++) {
            set.forEach(item -> System.out.print(item + " | "));
            System.out.println();
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove((Integer) nums[i - k]); // set is not ordinary data structure, if here you remove the first one, but it may not be the first element in arr.
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        TreeSet ts = new TreeSet();
        ts.add(3);
        ts.add(3);
        ts.add(3);
        ts.add(3);
        ts.add(13);
        System.out.println(ts.ceiling(3));
        System.out.println(ts.floor(3));
    }
}
