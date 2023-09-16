package leetcode.linkedList;

class LinkedNode {
    public Integer val;
    public LinkedNode next;

    LinkedNode(Integer val) {
        this.val = val;
    }
}

public class CustomLinkedList {
    private int size;
    private LinkedNode head;

    public CustomLinkedList() {
        head = new LinkedNode(null);
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0) return -1;
        if (index > size - 1) return -1;
        LinkedNode temp = head;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    // [1,2,7]
    // [3,1,7]
    public void addAtHead(int val) {
        LinkedNode newNode = new LinkedNode(val);
        newNode.next = head.next;
        head.next = newNode;
        this.size++;
    }

    public void addAtTail(int val) {
        LinkedNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = new LinkedNode(val);
        this.size++;
    }

    // [3,1,2,7]
    public void addAtIndex(int index, int val) {
        if (index < 0) return;
        if (index > size) return;
        LinkedNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        LinkedNode newNode = new LinkedNode(val);
        newNode.next = temp.next;
        temp.next = newNode;
        this.size++;
    }

    // [3,1,7]
    public void deleteAtIndex(int index) {
        if (index < 0) return;
        if (index > size - 1) return;
        LinkedNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        LinkedNode deleteNode = temp.next;
        temp.next = temp.next.next;
        deleteNode.next = null;

        this.size--;
    }

    public static void main(String[] args) {
//        ["MyLinkedList",
//        "addAtHead","addAtHead","addAtHead",
//        "addAtIndex",
//        "deleteAtIndex","addAtHead",
//        "addAtTail","get","addAtHead","addAtIndex","addAtHead"]
//[[],
// [7],[2],[1],
// [3,0],
// [2],[6],
// [4],[4],[4],[5,0],[6]]
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addAtHead(7);
        customLinkedList.addAtHead(2);
        customLinkedList.addAtHead(1);
        customLinkedList.addAtIndex(3, 0);
        customLinkedList.deleteAtIndex(2);
        customLinkedList.addAtHead(6);
        customLinkedList.addAtTail(4);
        customLinkedList.get(4);
        customLinkedList.addAtHead(4);
        customLinkedList.addAtIndex(5, 0);
        customLinkedList.addAtHead(6);
    }
}
