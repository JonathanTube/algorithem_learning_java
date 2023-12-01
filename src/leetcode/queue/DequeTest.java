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
        deque.offerLast(5);
        deque.offerFirst(0);
        deque.removeFirst();
        deque.removeLast();
        deque.push(0);
        deque.pop();
        deque.removeFirst();


        deque.forEach(item -> System.out.print(item + "-"));
        System.out.println();
        System.out.println(deque.peekLast());
//        System.out.println(deque.pollLast());
        System.out.println(deque.poll());
//        System.out.println(deque.pollFirst());
    }
}
