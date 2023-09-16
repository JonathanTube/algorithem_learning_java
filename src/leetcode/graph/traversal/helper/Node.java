package leetcode.graph.traversal.helper;

/**
 * 这里不能用queue，迭代的时候出栈，
 * 就会把图的adjacency List 清空
 * 所以自己构建链表
 */
public class Node<T> {
    public T val;
    public Node<T> prev;
    public Node<T> next;
    public Node(T val){
        this.val = val;
    }
}
