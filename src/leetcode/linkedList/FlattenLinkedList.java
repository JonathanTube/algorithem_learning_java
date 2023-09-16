package leetcode.linkedList;

import commons.TreeNode;

public class FlattenLinkedList {
    public void flatten(TreeNode root) {
        traversal(root);
    }

    private void traversal(TreeNode root) {
        if(root == null || root.left == null) return;
        TreeNode rightTree  = root.right;
        root.right = root.left;
        TreeNode node = root;
        while(node.right != null) node = node.right;
        node.right = rightTree;
        root.left = null;
        traversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        FlattenLinkedList fll = new FlattenLinkedList();
        fll.flatten(root);
    }
}
