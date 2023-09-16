package educative.array;

class ProductArray2 {
    public static int[] findProduct(int arr[]) {
        int[] arr1 = new int[arr.length];
        int p = 1;
        // [1, 1, 2, 6]
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = p;
            p *= arr[i];
        }

        System.out.println(arrayToString(arr1));;

        // [24, 12, 4, 1]
        int[] arr2 = new int[arr.length];
        int q = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            arr2[i] = q;
            q *= arr[i];
        }

        System.out.println(arrayToString(arr2));;

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr1[i] * arr2[i];
        }
        return arr2;
    }

    public static String arrayToString(int arr[]) {
        if (arr.length > 0) {
            String result = "";
            for (int i = 0; i < arr.length; i++) {
                result += arr[i] + " ";
            }
            return result;
        } else {
            return "Empty Array!";
        }
    }

    public static void main(String args[]) {

        int[] arr = {1, 2, 3, 4};

        System.out.println("Array before product: " + arrayToString(arr));

        int[] prodArray = findProduct(arr);

        System.out.println("Array after product: " + arrayToString(prodArray));
    }
} 