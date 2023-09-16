package leetcode.linkedList;

import commons.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReorderLink {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        
        // find the mid node
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            dummyHead = dummyHead.next;
        }

        ListNode cur = dummyHead.next;
        dummyHead.next = null; // cut off the link

        // the slow node is the mid node
        // revert the list
        ListNode prev = null;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode newHead = new ListNode(-1);
        ListNode node = newHead;
        // so the prev is the head node of the reverted list

        while(head != null) {
            node.next = head;
            node = node.next;
            head = head.next;

            node.next = prev;
            prev = prev.next;
            node = node.next;
        }

        if(prev != null) node.next = prev;

        head = newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(1, 2, 3, 4);
        ReorderLink reorderLink = new ReorderLink();
        reorderLink.reorderList(head);
        head.print();
    }
}