package leetcode.stack;

import commons.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class DeleteLinkListNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null || n < 1) return head;

        ListNode root = new ListNode(-1, head);

        ListNode fast = root;
        ListNode slow = root;
        for (int i = 0; i < n; i++) { // 快指针移动n次
            fast = fast.next;
        }
        while (fast.next != null) { // 快慢指针一起移动
            fast = fast.next;
            slow = slow.next;
        }
        // 慢指针指向的位置的下一个节点就是要删除的
        slow.next = slow.next.next;
        return root.next;
    }

    public static void main(String[] args) {
        ListNode root = ListNode.build(1, 2, 3, 4, 5);
        root.print();
        DeleteLinkListNode deleteLinkListNode = new DeleteLinkListNode();
        ListNode newRoot = deleteLinkListNode.removeNthFromEnd(root, 2);
        newRoot.print();
    }
}
