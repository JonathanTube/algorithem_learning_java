package educative.sort;

import java.util.Arrays;

public class InsertionSort2 {
    private static void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j  = i;
            while(j > 0 && temp < arr[j - 1]){
                arr[j] = arr[j - 1];
                j --;
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
