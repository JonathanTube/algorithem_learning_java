package leetcode.array;

import java.util.Arrays;

public class TwoArrayInteraction {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] arr = new int[1000];
        for (int i = 0; i < nums1.length; i++) {
            if (arr[i] == 0) arr[nums1[i]] = 1;
        }
        for (int i = 0; i < nums2.length; i++) arr[nums2[i]] += 1;
        int[] result = new int[Math.max(nums1.length, nums2.length)];
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = arr[i];
            while (count > 1) {
                result[len++] = i;
                count--;
            }
        }
        return Arrays.copyOfRange(result, 0, len);
    }

    public static void main(String[] args) {
        TwoArrayInteraction twoArrayInteraction = new TwoArrayInteraction();
        int[] result = twoArrayInteraction.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
