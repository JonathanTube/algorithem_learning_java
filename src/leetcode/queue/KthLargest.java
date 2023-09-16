package leetcode.queue;

import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] nums) {
        for(int num : nums) pq.offer(num); // [8,5,4,2]
        this.k = k;
    }

    public int add(int val) {
        pq.offer(val);
        while(pq.size() > k) pq.poll();
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest =new KthLargest(3, new int[]{4,5,8,2});
        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);
        kthLargest.add(4);
    }
}