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
class ReverseLinkedByRange {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head  == null || head.next == null) return head;

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode leftListTail = dummyHead;

        int index = 0;
        while(index + 1 < left) {
            leftListTail = leftListTail.next;
            index ++;
        }
        ListNode midListHead = leftListTail.next;

        ListNode midListTail = leftListTail;
        while(index < right) {
            midListTail = midListTail.next;
            index ++;
        }
        ListNode rightListHead = midListTail.next;

        midListTail.next = null;

        ListNode newMid = reverseLinkedList(midListHead);
        newMid.print();

        leftListTail.next = newMid;

        ListNode midNode = newMid;
        while(midNode.next != null) midNode = midNode.next;

        midNode.next = rightListHead;

        return dummyHead.next;
    }

    public ListNode reverseLinkedList(ListNode head) {
        ListNode newHead = null;
        ListNode nextNode = null;
        ListNode currentNode = head;
        while(currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = newHead;
            newHead = currentNode;
            currentNode = nextNode;
        }
        return newHead;
    }


    public ListNode reverseBetween2(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    public ListNode reverseBetween3(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        for(int i = 0; i < left - 1; i++) prev = prev.next;

        ListNode cur = prev.next;

        for(int i = 0; i < right - left; i++) {
            ListNode temp =  cur.next;
            cur.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
        ReverseLinkedByRange reverseLinkedByRange = new ReverseLinkedByRange();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//        revertLinkedByRange.reverseLinkedList(head).print();;
//        revertLinkedByRange.reverseBetween(head, 2, 4).print();
        reverseLinkedByRange.reverseBetween2(head, 2, 4).print();
//        revertLinkedByRange.reverseBetween3(head, 2, 4).print();
    }
}