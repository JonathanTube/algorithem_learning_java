package leetcode.linkedList;

import commons.ListNode;

public class ReverseLinkedList4 {
    /**
     * iteration
     *
     * @param head
     * @return
     */
    public static ListNode reverseLinkedList(ListNode head) {
        // 如果根节点为空直接返回
        // 如果当前节点的下一个节点为空，那说明到达了链表的尾节点
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseLinkedList(head.next);
        System.out.println(String.format("head = %s & newHead = %s", head.val, newHead.val));
        // 此时，当head节点传入，满足其下一个节点为空，即开始回溯，newNode当前是尾节点
        // 那head.next是尾结点，那head自然是倒数第二个节点
        head.next.next = head;// 反转倒数第二个节点的下一个节点指向
        head.next = null;
        return newHead; // 每次返回的都是最后一个尾结点，当递归回溯结束是，即是反转后的链表头节点
    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(1, 2, 3, 4, 5);
        ListNode newHead = reverseLinkedList(head);
        newHead.print();
    }
}
