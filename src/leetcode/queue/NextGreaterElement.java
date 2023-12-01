package leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Find the next greater element.
        // We can go through back to front the get each greater element to current element
        // put them into a map, then we can iterate each element of nums1 get the result via the key.
        Map<Integer, Integer> map = new HashMap<>();

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int temp = nums2[i];
            if (deque.isEmpty()) {
                map.put(temp, -1);
                deque.offer(temp);
                continue;
            }

            while (!deque.isEmpty() && deque.peek() < temp) {
                deque.pop();
            }

            if (deque.isEmpty()) {
                map.put(temp, -1);
            } else {
                map.put(temp, deque.peek());
            }
            deque.offer(temp);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        nextGreaterElement.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }
}
