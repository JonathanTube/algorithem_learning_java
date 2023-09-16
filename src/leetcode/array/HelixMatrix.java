package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class HelixMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int len = matrix.length * matrix[0].length;

        List<Integer> result = new ArrayList<>(len);

        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;

        while (left <= right) {
            result.forEach(item -> System.out.print(item + " "));
            System.out.println("top=" + top + " right=" + right + " bottom=" + bottom + " left=" + left);
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int j = top; j <= bottom; j++) {
                result.add(matrix[j][right]);
            }
            right--;

            for (int k = right; k >= left; k--) {
                result.add(matrix[bottom][k]);
            }
            bottom--;

            for (int l = bottom; l >= top; l--) {
                result.add(matrix[l][left]);
            }
            left++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        spiralOrder(arr).forEach(item -> System.out.print(item + " "));

    }
}
