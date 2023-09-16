package leetcode.dp;

import java.util.Arrays;

class TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        // left + right = sum;
        // left - right = target;
        // 2 * left = sum + target;
        // left = (sum + target) / 2;
        int left = (sum + target) / 2; // (1 + 1) / 2 = 0

        if(left % 2 == 1) return 0;

        System.out.println("left=" +left);
        
        int[] dp = new int[left + 1];
        dp[0] = 1; // 物品重量为0，背包容量为0，就一种装法， 物品重量为0， 背包容量为1，有0种装法

        for(int i = 0; i < nums.length; i++) { // nums.length = 1
            System.out.println(Arrays.toString(dp));
            for(int j = left; nums[i] <= j; j --) { // left = 0; j = 0; nums[0]= 1 <=
                System.out.println("capacity="+left+" i=" + i+ " j=" + j + " nums[" + i + "]=" + nums[i]);
                dp[j] += dp[j - nums[i]]; // 这里为什么是这样？装满容量为j - weight的背包有多少种方法
            }
        }

        return dp[left];
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,13,1,2,1}, 14));
    }
}