package educative.array;

public class ProductArray3 {
    public static int[] findProduct(int arr[]) {
        if (arr.length <= 2) return arr;

        int[] result = {0};

        // write your code here
        int[] arr1 = new int[arr.length];
        int p = 1;
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = p;
            p *= arr[i];
        }

        int[] arr2 = new int[arr.length];
        int q = 1;
        for (int j = arr.length - 1; j >= 0; j--) {
            arr2[j] = arr[j] *  q;
            q *= arr1[j];
        }
        return arr2;
    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4};
        int[] prodArray = findProduct(arr);
    }
}
