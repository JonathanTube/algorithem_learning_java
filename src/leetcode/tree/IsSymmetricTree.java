package leetcode.tree;

import commons.TreeNode;

public class IsSymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode != null) return false;
        if (leftNode != null && rightNode == null) return false;
        if (leftNode == null && rightNode == null) return true;
        if (leftNode.val != rightNode.val) return false;

        boolean isLeftSymmetric = isSymmetric(leftNode.left, rightNode.right);
        boolean isRightSymmetric = isSymmetric(leftNode.right, rightNode.left);
        return isLeftSymmetric && isRightSymmetric;
    }

    public static void main(String[] args) {
//        [1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        root.left = treeNode1;
        root.right = treeNode2;

        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(3);
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        isSymmetric(root);

    }
}
