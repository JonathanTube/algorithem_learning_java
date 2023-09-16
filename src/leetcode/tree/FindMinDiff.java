package leetcode.tree;

import commons.TreeNode;

public class FindMinDiff {
    int minValue = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return minValue;
        int leftMinValue = getMinimumDifference(root.left);
        int rightMinValue = getMinimumDifference(root.right);
        minValue = Math.min(leftMinValue, rightMinValue);

        int leftDiff = Integer.MAX_VALUE;
        if (root.left != null) {
            leftDiff = Math.abs(root.val - root.left.val);
        }

        int rightDiff = Integer.MAX_VALUE;
        if (root.right != null) {
            rightDiff = Math.abs(root.val - root.right.val);
        }

        return Math.min(Math.min(leftDiff, rightDiff), minValue);
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        node4.left = node2;
        node4.right = node6;
        FindMinDiff findMinDiff = new FindMinDiff();
        int result = findMinDiff.getMinimumDifference(node4);
        System.out.println("result=" + result);
    }
}
