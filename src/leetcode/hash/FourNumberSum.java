package leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumberSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > target) return result;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] > target) return result;
                if (j > 1 && nums[j - 1] == nums[j]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right - 1] == nums[right]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourNumberSum fourNumberSum = new FourNumberSum();
//        fourNumberSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        fourNumberSum.fourSum(new int[]{2, 2, 2, 2, 2}, 8);
    }
}
