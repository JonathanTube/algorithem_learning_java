package educative.sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    private static void sort(int[] arr) {
        mergeSort(arr,0,arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        System.out.println("left=" + left + "&mid=" + mid + "&right=" + right);
        int[] newArr = new int[right - left + 1];

        int leftIndex = left;
        int rightIndex = mid + 1;
        int index = 0;

        while(leftIndex <= mid && rightIndex <= right) {
            newArr[index++] = arr[leftIndex] < arr[rightIndex] ? arr[leftIndex ++] : arr[rightIndex++];
        }

        while(leftIndex <= mid) newArr[index++] = arr[leftIndex ++];
        while (rightIndex <= right) newArr[index++] = arr[rightIndex++];

        for (int i = 0; i < newArr.length; i++) {
            arr[left + i] = newArr[i];
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int size = 10;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(size);
        }
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
