package leetcode.linkedList;

import commons.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            if (stack.isEmpty()) {
                stack.push(temp.val);
            } else {
                Integer topVal = stack.peek();
                if (temp.val == topVal) stack.pop();
                else stack.push(temp.val);
            }
            temp = temp.next;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}
