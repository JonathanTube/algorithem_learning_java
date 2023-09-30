package leetcode.slideWindow;

import java.util.Arrays;

public class MaximumAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k) {
        // 题目要求精度，如果是整数整除，得到还是整数，不符合题意
        // 所以这里要用float或者double
        double maxVal = Math.pow(-10, 5);
        double currentVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                currentVal += nums[i];
            } else {
                currentVal += nums[i] - nums[i - k];
            }
            maxVal = Math.max(maxVal, currentVal);
        }
        return maxVal / k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }
}
