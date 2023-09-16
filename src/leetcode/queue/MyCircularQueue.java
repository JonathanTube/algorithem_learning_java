package leetcode.queue;

class MyCircularQueue {
    private int[] arr;
    private int capacity;
    private int size = 0;
    private int frontIndex = 0;
    private int endIndex = 0;

    public MyCircularQueue(int k) {
        arr = new int[k];
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        if(isEmpty()) {
            arr[frontIndex++] = value;
            endIndex ++;
        }else {
            arr[endIndex] = value;
            endIndex = (endIndex + 1) % capacity;
        }
        size ++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        frontIndex ++;
        size --;
        if(frontIndex == endIndex) endIndex ++;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return arr[frontIndex];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        // 如果endIndex = 0; size = 3; 如何取 endIndex = 2?
        if(endIndex == 0) return arr[capacity - 1];
        return arr[endIndex - 1];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
//        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
//        myCircularQueue.enQueue(1);
//        myCircularQueue.enQueue(2);
//        myCircularQueue.enQueue(3);
//        myCircularQueue.enQueue(4);
//        myCircularQueue.Rear();
//        myCircularQueue.isFull();
//        myCircularQueue.deQueue();
//        myCircularQueue.enQueue(4);
//        myCircularQueue.Rear();

        MyCircularQueue myCircularQueue = new MyCircularQueue(6);
        myCircularQueue.enQueue(6);
        myCircularQueue.Rear();
        myCircularQueue.Rear();
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(5);
        myCircularQueue.Rear();
    }
}