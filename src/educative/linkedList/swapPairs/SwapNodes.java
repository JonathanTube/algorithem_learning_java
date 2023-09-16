package educative.linkedList.swapPairs;

public class SwapNodes{
  public static LinkedListNode swapPairs(LinkedListNode head) {
    LinkedListNode dummyHead = new LinkedListNode(-1);
    dummyHead.next = head;
    // dummyHead = [-1,1,2,3,4]
    LinkedListNode prev = dummyHead; // -1
    while(prev.next != null && prev.next.next != null) {
      LinkedListNode temp = prev.next.next;
      prev.next.next = temp.next;
      temp.next = prev.next;
      prev.next = temp;
      prev = prev.next.next;
    }

    return dummyHead.next;
  }

  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    linkedList.createLinkedList(new int[]{1,2,3,4});
    LinkedListNode node  = swapPairs(linkedList.head);
    while (node!= null) {
      System.out.print(node.data + "->");
      node  = node.next;
    }
    System.out.println();
  }
}