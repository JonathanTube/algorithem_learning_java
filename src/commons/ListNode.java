package commons;

public class ListNode {
    public int val;
    public ListNode next;

    public static ListNode build(int... n) {
        ListNode headNode = null;
        ListNode currentNode = null;
        for (int i = 0; i < n.length; i++) {
            ListNode listNode = new ListNode(n[i]);
            if (i == 0) {
                headNode = listNode;
                currentNode = listNode;
            } else {
                currentNode.next = listNode;
                currentNode = currentNode.next;
            }
        }
        return headNode;
    }

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public void print() {
        ListNode p = this;
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
            if (p != null) System.out.print("->");
        }
        System.out.println();
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {

    }
}
