package leetcode.array;

public class MergeTwoSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int left = m - 1;
        int right = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (m == 0) {
                nums1[i] = nums2[right--];
                continue;
            }
            if (right >= 0 && left >=0 && nums2[right] > nums1[left]) {
                nums1[i] = nums2[right--];
            } else {
                nums1[i] = nums1[left];
                nums1[left] = nums2[right];
                left --;
            }
        }
    }

    public static void main(String[] args) {
        merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }
}
