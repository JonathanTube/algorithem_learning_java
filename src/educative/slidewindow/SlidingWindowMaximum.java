package educative.slidewindow;

import java.util.*;

class SlidingWindowMaximum {
    public static int[] findMaxSlidingWindow(int[] nums, int w) {
        int[] result = new int[nums.length - w + 1];
        if (nums.length == 0) return result;
        if (w > nums.length) w = nums.length;

        Deque<Integer> queue = new LinkedList<>();

        for (int right = 0; right < nums.length; right++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[right]) queue.pollLast();
            queue.offerLast(right);

            int left = right - w + 1;
            if (left > queue.peekFirst()) queue.pollFirst();

            if (right >= w - 1) result[left] = nums[queue.peekFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = findMaxSlidingWindow(new int[]{9, 5, 3, 1, 6, 3}, 2);
        System.out.println(Arrays.toString(arr));
        System.out.println("AAAAACCCCCAAAAACCCCCC".substring(9,9+8));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    }
}