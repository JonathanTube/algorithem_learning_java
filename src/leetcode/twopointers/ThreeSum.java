package leetcode.twopointers;

import java.util.*;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 将三数之和转换为两数之和问题
            int target = -nums[i];
            // 定义两数之和的左右边界
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > target) right--;
                else if (sum < target) left++;
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                    //排序前=[-1,0,1,2,-1,-4]
                    //排序后=[-4,-1,-1,0,1,2]
                    // 可能连续重复，所以不能直接移动,要排除掉重复的
                    while (left < nums.length && nums[left] == nums[left - 1]) left++;
                    while (right > left && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});

    }
}