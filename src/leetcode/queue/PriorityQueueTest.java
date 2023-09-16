package leetcode.queue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public class Element {
        public int value;
        public int times;

        Element(int value, int times) {
            this.value = value;
            this.times = times;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Element> priorityQueue = new PriorityQueue<>(new Comparator<Element>() {
            public int compare(Element o1, Element o2) {
                return o2.times - o1.times;
            }
        });
        map.forEach((Integer key, Integer value) -> {
            priorityQueue.add(new Element(key, value));
        });

        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            result[i] = priorityQueue.poll().value;
        }

        return result;
    }
}
