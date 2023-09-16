package leetcode.linkedList;

import commons.ListNode;

public class ReverseLinkedList2 {
    /**
     * iteration
     *
     * @param head
     * @return
     */
    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode p = head.next;
            if (newHead == null) {
                newHead = head;
                head.next = null;
            } else {
                head.next = newHead;
                newHead = head;
            }
            head = p;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(1, 2, 3, 4, 5);
        ListNode newHead = reverseLinkedList(head);
        newHead.print();
    }
}
