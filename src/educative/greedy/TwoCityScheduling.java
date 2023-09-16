package educative.greedy;

import java.util.Arrays;

public class TwoCityScheduling {
    public static int twoCityScheduling(int[][] costs) {
        int totalCost = 0;
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int costLength = costs.length;

        for (int i = 0; i < costLength / 2; i++) {
            totalCost += costs[i][0] + costs[costLength - i - 1][1];
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
//        Arrays.sort(arr,  (o1, o2) -> o1 - o2);
//        System.out.println(costs);
    }
}
