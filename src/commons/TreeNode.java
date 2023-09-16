package commons;

import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public void printTree() {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(this);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) System.out.print("null->");
            else {
                System.out.print(node.val + "->");
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        System.out.println("===================================");
    }

}
