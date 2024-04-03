package leetcode.priorityQueue;

import java.util.ArrayList;
import java.util.List;

public class MyPriorityQueueWithArray {
    private final List<Integer> arr;

    MyPriorityQueueWithArray() {
        this.arr = new ArrayList<>();
    }

    private void push(Integer val) {
        int len = this.arr.size();
        this.arr.add(len, val);
        this.shiftUp(len);
    }

    private Integer pop() {
        int len = this.arr.size();
        if (len == 0) return null;
        // 交换第0个节点，和最后一个节点
        swap(0, len - 1);
        // 删除最后一个节点
        Integer result = this.arr.remove(len - 1);
        // 第0个节点，需要判断他的位置
        this.shiftDown(0);
        return result;
    }

    private void shiftDown(int index) {
        int len = this.arr.size();
        int left = index * 2 + 1;
        if (left > len - 1) return;
        int minIndex = this.arr.get(left) < this.arr.get(index) ? left : index;

        int right = left + 1;
        if (right <= len - 1) {
            minIndex = this.arr.get(right) < this.arr.get(minIndex) ? right : minIndex;
        }
        swap(index, minIndex);
        shiftDown(minIndex);
    }

    private void shiftUp(Integer index) {
        if (index == 0) return;
        // left = parent * 2 + 1 => parent = (left - 1) / 2
        // right = parent * 2 + 2 => parent = (right - 2) / 2
        int parentIndex = (index - 1) >> 1;
        if (this.arr.get(index) < this.arr.get(parentIndex)) {
            this.swap(index, parentIndex);
        }
        shiftUp(parentIndex);
    }

    private void swap(Integer left, Integer right) {
        int len = this.arr.size();
        if (left >= len || right >= len || left.equals(right)) return;
        Integer leftVal = this.arr.get(left);
        Integer rightVal = this.arr.get(right);
        this.arr.set(left, rightVal);
        this.arr.set(right, leftVal);
    }

    public void print() {
        for (Integer value : arr) {
            System.out.print(value + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyPriorityQueueWithArray myPriorityQueueWithArray = new MyPriorityQueueWithArray();
        myPriorityQueueWithArray.push(1);
        myPriorityQueueWithArray.push(0);
        myPriorityQueueWithArray.push(2);
        myPriorityQueueWithArray.print();

        myPriorityQueueWithArray.push(-1);
        myPriorityQueueWithArray.print();

        myPriorityQueueWithArray.push(10);
        myPriorityQueueWithArray.push(-20);
        myPriorityQueueWithArray.print();

        myPriorityQueueWithArray.pop();
        myPriorityQueueWithArray.print();
    }
}
