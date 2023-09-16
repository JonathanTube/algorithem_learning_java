package leetcode.linkedList;

import commons.ListNode;

public class ReverseLinkedList {
    /**
     * iteration
     *
     * @param head
     * @return
     */
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;
        while (fast != null) {
            ListNode temp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = temp;
        }
        return slow;
    }

    public static ListNode reverseLinkedListRecursion(ListNode slow, ListNode fast) {
        if (fast == null) return slow;
        ListNode temp = fast.next;
        fast.next = slow;
        return reverseLinkedListRecursion(fast, temp);
    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(1, 2, 3, 4, 5);
//        ListNode newHead = reverseLinkedList(head);
//        newHead.print();
        reverseLinkedListRecursion(null, head).print();
    }
}
