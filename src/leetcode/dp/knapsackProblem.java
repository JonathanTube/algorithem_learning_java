package leetcode.dp;

import java.util.Arrays;

public class knapsackProblem {
    static int knapsack(int profits[], int weights[], int capacity) {
        int[] dp = new int[capacity + 1];
        int len = profits.length;
        for(int i = 0; i < len; i ++) {
            System.out.println(Arrays.toString(dp));
            for(int j = 1; j <= capacity; j++) {
                int temp = 0;
                if(j - weights[i] >= 0) temp = dp[j - weights[i]] + profits[i];
                dp[j] = Math.max(dp[j], temp);
            }
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int capacity = 30;
        int result = knapsack(profit, weight, capacity);
        System.out.println(result);
    }
}
