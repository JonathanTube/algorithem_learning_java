package educative.dynamicprograming;

class KnapsackProblem {
    static int knapsack(int profits[], int weights[], int capacity) {
        int len = weights.length;
        int[][] dp = new int[len + 1][capacity + 1];

        for (int i = 0; i <= len; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                    continue;
                }
                int profit1 = dp[i - 1][w];
                int profit2 = weights[i - 1] > w ? profit1 : profits[i - 1] + dp[i - 1][w - weights[i - 1]];
                dp[i][w] = Math.max(profit1, profit2);
            }
            printArr(dp);
        }
        return dp[len][capacity];
    }

    static void printArr(int[][] arr) {
        System.out.println("[");
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
//        ([60, 100, 120], 3, [10, 20, 30], 3, 30
        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int capacity = 30;
        int result = knapsack(profit, weight, capacity);
        System.out.println(result);
    }

}