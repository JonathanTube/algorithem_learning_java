package leetcode.linkedList;

import commons.ListNode;

public class ReverseLinkedList3 {
    /**
     * iteration
     *
     * @param head
     * @return
     */
    public static ListNode reverseLinkedList(ListNode head) {
        if(head == null) return null;
        System.out.println("current1=" + head.val);
        if(head.next == null) return head;
        ListNode newHead = reverseLinkedList(head.next);
        System.out.println("current2=" + head.val);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(1, 2, 3, 4, 5);
        ListNode newHead = reverseLinkedList(head);
        newHead.print();
    }
}
