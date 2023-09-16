package educative.sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort2 {

    private static void sort(int[] arr) {
        mergeSort(arr,0,arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(left >= right) return;
        int mid = left +(right - left) / 2;
        // handle left
        mergeSort(arr,left,mid);
        // handle right
        mergeSort(arr,mid+1,right);
        // merge left and right
        merge(arr,left,mid,right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tempArr = new int[right-left+1];
        int tempIndex = 0;
        int leftIndex = left;
        int rightIndex = mid+1;
        while(leftIndex <= mid && rightIndex <=right) {
            tempArr[tempIndex ++] = arr[leftIndex] < arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }
        while(leftIndex <= mid) tempArr[tempIndex ++] = arr[leftIndex ++];
        while(rightIndex <= right) tempArr[tempIndex ++] = arr[rightIndex ++];
        for (int i = 0; i < tempArr.length; i++) {
            arr[left + i] = tempArr[i];
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
