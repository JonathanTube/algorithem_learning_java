package leetcode.array;

import java.util.TreeSet;

public class ThirdMaxNum {
    public static int thirdMax(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (Integer num : nums) {
            ts.add(num);
            if (ts.size() > 3) ts.remove(ts.first());
        }
        return ts.size() < 3 ? ts.last() : ts.first();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(thirdMax(nums));
    }
}
