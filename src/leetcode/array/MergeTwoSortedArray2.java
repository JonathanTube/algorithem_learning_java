package leetcode.array;

public class MergeTwoSortedArray2 {
    public static int[] merge(int[] arr1, int[] arr2) {
        int pos1 = 0;
        int pos2 = 0;
        int pos = 0;
        int[] arr = new int[arr1.length + arr2.length];
        while (pos1 < arr1.length && pos2 < arr2.length) {
            if (arr1[pos1] < arr2[pos2]) arr[pos++] = arr1[pos1++];
            else arr[pos++] = arr2[pos2++];
        }
        while (pos1 < arr1.length) arr[pos++] = arr1[pos1++];
        while (pos2 < arr2.length) arr[pos++] = arr2[pos2++];
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = merge(new int[]{1, 3, 4, 5}, new int[]{2, 6, 7, 8});
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
    }
}
