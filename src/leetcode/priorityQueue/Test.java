package leetcode.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        // 默认小顶锥
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < 10; i++) {
            pq.offer(new Random().nextInt(10));
        }

        for (int i = 0; i < pq.size(); i++) {
            System.out.println(pq.poll());
        }

        System.out.println();

        // 大顶锥
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < 10; i++) {
            pq2.offer(new Random().nextInt(10));
        }

        for (int i = 0; i < pq2.size(); i++) {
            System.out.println(pq2.poll());
        }
    }
}
