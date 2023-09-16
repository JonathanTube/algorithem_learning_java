package leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.offer(4);
        deque.offerFirst(11);
        deque.forEach(item -> System.out.print(item + "-"));
        System.out.println(deque.peekLast());
//        System.out.println(deque.pollLast());
        System.out.println(deque.poll());
//        System.out.println(deque.pollFirst());
    }
}
