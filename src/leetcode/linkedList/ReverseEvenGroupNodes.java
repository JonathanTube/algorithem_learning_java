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
class ReverseEvenGroupNodes {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int len = 1;
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null) {
            if(len % 2 == 1) { // odd
                ListNode tail = null;
                prev = cur;
                int nextLen = len + 1;
                while(cur != null && nextLen > 0) {
                    cur = cur.next;
                    nextLen --;
                    tail = cur;
                }
                if(tail == null) break;
                ListNode afterTail = tail.next;
                tail.next = null;
                ListNode revertNode = reverseLinkedList(prev.next);
                merge(prev, revertNode, afterTail);
                len = len + 2;
            }
            cur = cur.next;
        }
        return head;
    }

    private ListNode reverseLinkedList(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private void merge(ListNode prev, ListNode mid, ListNode tail) {
        prev.next = mid;
        ListNode node = mid;
        while(node.next != null) node = node.next;
        node.next = tail;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.build(1,2,3,4,5,6,7,9);
        ReverseEvenGroupNodes reverseEvenGroupNodes = new ReverseEvenGroupNodes();
        reverseEvenGroupNodes.reverseEvenLengthGroups(node).print();
    }
}