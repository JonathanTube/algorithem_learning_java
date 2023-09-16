package educative.dynamicprograming;

import java.util.Arrays;

public class KnapsackProblems {
    public static int findMaxKnapsackProfit(int capacity, int [] weights, int [] values) {
        int[] dp = new int[capacity + 1]; // 初始化dp数组，这里的dp是值容量为N的背包，装下的物品的最大价值
        for(int i = 0; i < weights.length; i++) {// java中默认被初始化成了1，所以容量为0的背包默认是0：dp[0] = 0
            for(int j = capacity; weights[i] <= j; j--) {// 这里使用滚动数组；
                // 为什么要从后往前遍历？因为后面的数组只会依赖前面的计算结果；如果反过来，那每次迭代前面的数值被更新过，再次使用，就不符合逻辑
                dp[j] = Math.max(dp[j - weights[i]] + values[i], dp[j]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        System.out.println(findMaxKnapsackProfit(6 , new int[]{1, 2, 3, 5} , new int[]{1, 5, 4, 8}));
    }
}
