package leetcode.dp;

public class UniqueBinarySearchTrees {
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for(int i = 1; i <= n; i++) {
            dp[i] = 0;
            for(int j = 1; j <= i; j++) {
                int temp = dp[j - 1] * dp [i - j];
                dp[i] = dp[i] + temp;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
