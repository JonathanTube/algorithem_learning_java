package leetcode.linkedList;

import commons.ListNode;

public class MergeLinkList {
    public void mergeList(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return;
        if(l1 == null) return;
        if(l2 == null) return;
        while(l1 != null && l2 != null) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;
            l1.next = l2;
            l1 = temp1;

            l2.next = temp1;
            l2 = temp2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.build(1,3,5,7,9);
        ListNode l2 = ListNode.build(2,4,6,8);
        MergeLinkList mergeLinkList = new MergeLinkList();
        mergeLinkList.mergeList(l1, l2);
        l1.print();
        StringBuilder sb = new StringBuilder("Let's take LeetCode contest");
        System.out.println(sb.reverse().toString());
    }

}
