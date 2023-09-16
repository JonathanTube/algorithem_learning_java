package leetcode.greedy;

public class Test {
    public static int mostFrequent(int[] nums, int key) {
        int[] arr = new int[1000];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                int temp = nums[i + 1]; // 2
                arr[temp] += 1;
            }
        }
        int times = 0;
        int target = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > times) {
                target = i;
                times = arr[i];
            }
        }
        return target;
    }

    public static void main(String[] args) {
        System.out.println(mostFrequent(new int[]{2, 12, 12, 3}, 2));
        ;
    }
}
