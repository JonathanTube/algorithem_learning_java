package educative.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getMin(arr, i, arr.length - 1);
        }
    }

    private static int getMin(int[] arr, int start, int end) {
        int min = arr[start];
        for (int i = start + 1; i < end; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 12, 34, 51};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
