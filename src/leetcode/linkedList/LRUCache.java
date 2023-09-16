package leetcode.linkedList;

import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    // The functions get and put must each run in O(1) average time complexity.
    // 为什么要用map？因为get时间复杂度要求O(1)，只有数组和hash满足，但是数组插入删除要移动
    // 有了hashMap后，解决了get=O(1)的问题和put=O(1)的问题，还有使用频次排序的问题，容量的限制，超出容量需要移除掉最少使用的元素
    // 所以用链表，链表的头部add和delete都是O(1)的，所以将最近访问的插入到头部，删除的话放在队尾，那问题来了，放在队尾如何删除做到O(1)那就得用双向链表
    // 使用双向链表的第二个问题是：链表删除节点需要先找到前一个节点，所以要用双向
    // 这时map的value就不能存储值了，应该是存储链表的指针
    // Java的HashMap中插入和删除的时间复杂度为O(1)
    // 总之：使用hashmap是解决查找O(1)的问题；使用linkedList是解决访问频次次序问题；为了操作方便使用双向链表更容易删除尾节点实现删除全部O(1)
    class LinkedNode {
        int key;
        int val;
        LinkedNode next;
        LinkedNode prev;

        public LinkedNode() {
        }

        public LinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, LinkedNode> cache;
    private LinkedNode dummyHead;
    private LinkedNode dummyTail;

    private int len = 0;
    private int capacity = 0;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        dummyHead = new LinkedNode();
        dummyTail = new LinkedNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        this.capacity = capacity;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if(node == null) return -1; // 节点不存在
        // 访问过一次了，需要将节点移动到链表的头部
        removeNode(node);
        addNodeAtHead(node);
        // 将该节点插入头节点之后，hash表持有的引用不用改变
        return node.val;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        // 如果key不存在，创建一个新的节点
        if(node == null) {
            node = new LinkedNode(key, value);
            cache.put(key, node);
            if(this.len >= this.capacity) { // 超出容量
                // 删除最少使用的元素，也就是队尾元素
                LinkedNode delNode = dummyTail.prev;
                removeNode(delNode);
                cache.remove(delNode.key); // 删除hashMap
            }
        }else {
            node.val = value;// 否则改个值就行了
            removeNode(node);
        }
        // 在头部加入元素
        addNodeAtHead(node);
    }

    private void addNodeAtHead(LinkedNode newNode) {
        // 修改正向指向
        newNode.next = dummyHead.next;
        dummyHead.next = newNode;
        // 修改反向指向
        newNode.next.prev = newNode;
        newNode.prev = dummyHead;
        len ++;
    }

    private void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        len --;
    }

    private static void printLinkedList(LinkedNode dummyHead) {
        LinkedNode node = dummyHead;
        while(node!= null) {
            System.out.print(String.format("[%s=%s]->", node.key, node.val));
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
    // ["LRUCache","put","put","get","put","get","put","get","get","get"]
    //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1,1);
//        printLinkedList(lruCache.dummyHead);
//        lruCache.put(2,2);
//        printLinkedList(lruCache.dummyHead);
//        lruCache.get(1);
//        printLinkedList(lruCache.dummyHead);
//        lruCache.put(3,3);
//        printLinkedList(lruCache.dummyHead);
//        lruCache.get(2);
//        printLinkedList(lruCache.dummyHead);
//        lruCache.put(4,4);
//        printLinkedList(lruCache.dummyHead);
//        lruCache.get(1);
//        printLinkedList(lruCache.dummyHead);
//        lruCache.get(3);
//        printLinkedList(lruCache.dummyHead);
//        lruCache.get(4);
//        printLinkedList(lruCache.dummyHead);
        lruCache.put(2,1);
        printLinkedList(lruCache.dummyHead);
        lruCache.put(1,1);
        printLinkedList(lruCache.dummyHead);
        lruCache.put(2,3);
        printLinkedList(lruCache.dummyHead);
        lruCache.put(4,1);

        lruCache.get(1);
        lruCache.get(2);
    }
}