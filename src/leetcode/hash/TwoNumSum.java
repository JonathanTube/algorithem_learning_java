package leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            Integer idx = map.get(diff);
            if (idx != null) {
                result[0] = i;
                result[1] = idx;
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoNumSum twoNumSum = new TwoNumSum();
        int[] arr = new int[]{3, 2, 4};
        int[] a = twoNumSum.twoSum(arr, 6);
        Arrays.stream(a).forEach(item -> System.out.print(item + "->"));
    }
}
