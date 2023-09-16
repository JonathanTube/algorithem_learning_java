package leetcode.linkedList;

class FrontMiddleBackQueueByLink {

    class Node {
        public int val;
        public Node next;
        public Node prev;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }
    }

    private int size;

    private Node head;
    private Node tail;
    private Node mid;

    public FrontMiddleBackQueueByLink() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        mid = head;
        size = 0;
    }

    public void pushFront(int val) {
        addNodeBefore(head.next, val);
        // 中间节点什么时候移动？插入值之后
        // [2,3] => [1,2,3] 不移动
        // [2,3,4] => [1,2,3,4] 前移动
        if (size == 1) mid = mid.next;
        if (size % 2 == 0) mid = mid.prev;
    }

    public void pushMiddle(int val) {
        if (size == 0) {
            addNodeBefore(tail, val);
            mid = mid.next;
        } else if (size % 2 == 1) {
            // [1,2,3]
            addNodeBefore(mid, val);
            mid = mid.prev;
        } else {
            // [1,2,3,4]
            addNodeBefore(mid.next, val);
            mid = mid.next;
        }
    }

    public void pushBack(int val) {
        addNodeBefore(tail, val);
        // 中间节点什么时候移动？
        // [1,3] => [1,2,3] 移动
        // [1,2,3] => [1,2,3,4] 不移动
        if (size % 2 == 1) mid = mid.next;
    }

    public int popFront() {
        if (size == 0) return -1;
        // [1,2,3] => [2,3] 不需要移动
        // [1,2,3,4] => [2,3,4] 后移
        if(size == 1) mid = head;
        if (size % 2 == 0) mid = mid.next;
        return removeNode(head.next);
    }

    public int popMiddle() {
        if (size == 0) return -1;
        // [1,2,3] 移除2 [1,3]  向前移动
        // [1,2,3,4] 移除3 [1,2,4] 向后移动
        Node temp = size % 2 == 1 ? mid.prev : mid.next;
        int result = removeNode(mid);
        mid = temp;
        return result;
    }

    public int popBack() {
        if (size == 0) return -1;
        // [1,2,3] => [1,2] 向前移动
        // [1,2,3,4] => [1,2,3] 不需要移动
        if (size % 2 == 1) mid = mid.prev;
        return removeNode(tail.prev);
    }

    private int removeNode(Node node) {
        if (size == 0) return -1;
        Node temp = node.next;
        node.prev.next = temp;
        temp.prev = node.prev;
        node.next = null;
        node.prev = null;
        size--;
        return node.val;
    }

    /**
     * 在node节点前插入新的node
     */
    private void addNodeBefore(Node node, int val) {
        Node newNode = new Node(val);
        // 保存插入node节点的前一个节点
        Node prevNode = node.prev;
        // 将新的节点与当前节点建立关系
        newNode.next = node;
        node.prev = newNode;
        // 将新的节点与之前节点建立关系
        prevNode.next = newNode;
        newNode.prev = prevNode;
        size++;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
        System.out.println("mid.val=" + mid.val);
    }

    public static void main(String[] args) {
        FrontMiddleBackQueueByLink list = new FrontMiddleBackQueueByLink();
        list.popMiddle();
        list.print();

        list.popMiddle();
        list.print();

        list.pushMiddle(773222);
        list.print();

        list.pushMiddle(279355);
        list.print();

        list.popMiddle();
        list.print();

        list.popMiddle();
        list.print();

        list.popMiddle();
        list.print();

        list.popBack();
        list.print();

        list.popMiddle();
        list.print();

        list.popFront();
        list.print();

        list.pushBack(448905);
        list.print();

        list.popFront();
        list.print();
        list.pushMiddle(168284);
        list.print();
        list.pushMiddle(874541);
        list.print();
        list.popMiddle();
        list.print();
        list.popBack();
        list.print();
        list.pushFront(15656);
        list.print();
        list.popMiddle();
        list.print();
        list.pushMiddle(803226);
        list.print();
        list.pushMiddle(720129);
        list.print();
        list.pushMiddle(626048);
        list.print();
        list.popMiddle();
        list.print();
        list.pushMiddle(860306);
        list.print();
        list.popBack();
        list.print();
        list.pushMiddle(630886);
        list.print();
        list.popMiddle();
        list.print();
        list.popMiddle();
        list.print();
        list.popMiddle();
        list.print();
        list.popMiddle();
        list.print();
        list.popFront();
        list.print();
        list.pushMiddle(837735);
        list.print();
        list.pushMiddle(414354);
        list.print();
        list.pushMiddle(404946);
        list.print();
        list.pushFront(88719);
        list.print();
    }
}