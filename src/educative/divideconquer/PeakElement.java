package educative.divideconquer;

class PeakElement {
    public static int findPeak(int arr[]) {
        if (arr.length == 0) return -1;
        if (arr.length == 1) return arr[0];

        // your awesome code goes here
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] > arr[i + 1]) return arr[i];
            } else if (i == arr.length - 1) {
                if (arr[i] > arr[i - 1]) return arr[i];
            } else if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findPeak(new int[]{7, 11, 22, 13, 4, 0}));
        System.out.println(findPeak(new int[]{13, 27, 54, 11, 99, 1}));
        System.out.println(findPeak(new int[]{0, 1, 2, 3, 4, 5}));
        System.out.println(findPeak(new int[]{10, 9, 8, 7, 6}));
    }
}