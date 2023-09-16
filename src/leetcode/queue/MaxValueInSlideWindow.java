package leetcode.queue;

import java.util.LinkedList;

public class MaxValueInSlideWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int right = 0; right < nums.length; right++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[right]) queue.pollLast();

            queue.addLast(right);

            int left = right - k + 1;
            if (left > queue.peek()) queue.poll();

            if (right >= k - 1) {
                result[left] = nums[queue.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxValueInSlideWindow maxValueInSlideWindow = new MaxValueInSlideWindow();
        int[] arr = maxValueInSlideWindow.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int s : arr) {
            System.out.print(s + "-");
        }
    }
}
