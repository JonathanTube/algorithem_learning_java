package educative.twopointers.last;

public class PalindromeList{
  public boolean palindrome(LinkedListNode head) {
    LinkedListNode midNode = findMid(head);
    LinkedListNode right = reverseLinkedList(midNode);
    LinkedListNode left = head;
    while(left != null && right != null) {
      if(left == midNode) break;
      if(left.data != right.data) return false;
      left = left.next;
      right = right.next;
    }
    return true;
  }

  private  LinkedListNode findMid(LinkedListNode head) {
    LinkedListNode slow = head;
    LinkedListNode fast = head;
    while(fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  public LinkedListNode reverseLinkedList(LinkedListNode head) {
    if(head == null) return null;
    if(head.next == null) return head;
    LinkedListNode newNode = reverseLinkedList(head.next);
    head.next.next = head;
    head.next = null;
    return newNode;
  }

  public static void main(String[] args) {
    PalindromeList pl = new PalindromeList();
    LinkedListNode root = new LinkedListNode(1);
    root.next = new LinkedListNode(2);
    root.next.next = new LinkedListNode(3);
    root.next.next.next = new LinkedListNode(2);
    root.next.next.next.next = new LinkedListNode(1);
    pl.palindrome(root);
  }
}