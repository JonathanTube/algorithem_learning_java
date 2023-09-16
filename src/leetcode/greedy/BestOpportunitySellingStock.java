package leetcode.greedy;

public class BestOpportunitySellingStock {
    static int result = 0;

    public static int maxProfit(int[] prices) {
        for (int i = 0; i < prices.length; ) {
            int start = i;

            // find the cheapest one, if the next one is less or equal than the previous one.
            while (start < prices.length - 1 && prices[start + 1] <= prices[start]) start++;

            if (start >= prices.length) break;

            int end = start;
            // find the most expensive one.
            while (end < prices.length - 1 && prices[end + 1] > prices[end]) end++;
            if (end >= prices.length) break;

            result += prices[end] - prices[start];
            i = end + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
