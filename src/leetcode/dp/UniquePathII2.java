package leetcode.dp;

public class UniquePathII2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for (int i = 0; i < obstacleGrid.length; i++) obstacleGrid[0][i] = obstacleGrid[0][i] == 0 ? -1 : 0;
        for (int i = 0; i < obstacleGrid.length; i++) obstacleGrid[i][0] = obstacleGrid[i][0] == 0 ? -1 : 0;
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] * -1;
    }

    public static void main(String[] args) {
        System.out.println(UniquePathII2.uniquePathsWithObstacles(new int[][]{{0}}));
    }

    private static void printDP(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " | ");
            }
        }
        System.out.println();
    }
}
