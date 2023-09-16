package leetcode.array;

import java.util.Arrays;

public class Test3 {
    public static void maxMin(int[] arr) {
        int[] result = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < result.length; ) {
            if (left > right) break;
            result[i] = arr[right--];
            if (i + 1 < result.length) result[i + 1] = arr[left++];
            i += 2;
        }
        arr = Arrays.copyOf(result, result.length);
    }

    public static void main(String[] args) {
        maxMin(new int[]{1,2,3,4,5,6,7});
    }
}
