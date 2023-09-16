package leetcode.graph.traversal.helper;

public class AdjList<T> {
    public Node<T> head;
    public Node<T> tail;

    int size = 0;

    public void addHead(T val) {
        Node<T> newNode = new Node<>(val);
        if(size == 0) {
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size ++;
    }

    public void addLast(T val) {
        Node<T> newNode = new Node<>(val);
        if(size == 0) {
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }
        size ++;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
