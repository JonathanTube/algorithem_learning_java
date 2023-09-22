package leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 这个判断不能加，如果和>=0，那没问题第一个不能大于0，因为第一个大于0，那后面依旧大于0，永不成立
            // 但是这里要考虑到target是负数的情况,负数相加是可以更小的
            // if(nums[i] > target) return result;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            // 排序前=[1,-2,-5,-4,-3,3,3,5]
            // 排序后=[-5,-4,-3,-2,1,3,3,5]
            for (int j = i + 1; j < nums.length; j++) {
                // 这里j > i + 1，只与当前层比，不能和i去比较
                if (j > i + 1 && nums[j - 1] == nums[j]) continue;
                // -6 - (-4) = -2
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    // 这里居然不能用int接收,因为会越界
                    // int类型是正负2的31次方，大概是-2147483648 ~ 2147483647，10位数字
                    // 转成long比较
                    long temp = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (temp < (long) target) left++;
                    else if (temp > (long) target) right--;
                    else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;
                        right--;
                        while (left < right && nums[left - 1] == nums[left]) left++;
                        while (left < right && nums[right + 1] == nums[right]) right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
//        fourSum.fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11).forEach(System.out::println);
        fourSum.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296).forEach(System.out::println);
//        int s = 1000000000;
//        System.out.println(s);
//        System.out.println(s * 2);
//        System.out.println(s * 3);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println((int)Math.pow(2, 31));
    }
}
