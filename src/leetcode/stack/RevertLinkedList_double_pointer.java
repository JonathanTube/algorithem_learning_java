package leetcode.stack;

import commons.ListNode;

/**
 * reverse a linked list by looping algorithm.
 * [1,2,3,4,5]
 */
public class RevertLinkedList_double_pointer {
    public ListNode reverse(ListNode head) {
        ListNode prev = null; // 初始化设置一个前一节点
        ListNode cur = head; // // 初始化指向当前节点
        while (cur != null) { // 什么时候结束，当当前节点指向null的时候，也就是没有必要再去做反转了
            ListNode temp = cur.next; // 因为要反转前后节点，那后一个节点的指向的节点要提前保存下来，否则断链后无法找到
            cur.next = prev; // 当前节点指向前一个节点
            prev = cur; // 移动前节点
            cur = temp; // 移动后节点
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode root = ListNode.build(1, 2, 3, 4, 5);

        RevertLinkedList_double_pointer deleteLinkListNode = new RevertLinkedList_double_pointer();
        ListNode newRoot = deleteLinkListNode.reverse(root);

        newRoot.print();
    }
}
