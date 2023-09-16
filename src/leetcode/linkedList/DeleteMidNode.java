package leetcode.linkedList;

import commons.ListNode;

public class DeleteMidNode {
    public static void deleteNode(ListNode node) {
        if(node == null) return;
        ListNode dummyHead = new ListNode();
        dummyHead.next = node;
        ListNode prev = null;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = prev.next.next;
        node = dummyHead.next;
        node.print();
    }

    public static void main(String[] args) {
        ListNode root = ListNode.build(4,5,1,9);
        deleteNode(root);
    }
}
