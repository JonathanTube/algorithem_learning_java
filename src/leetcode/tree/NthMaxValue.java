package leetcode.tree;

import commons.TreeNode;

import java.util.TreeSet;

public class NthMaxValue {
    TreeSet<Integer> set = new TreeSet<>();
    public int kthLargest(TreeNode root, int k) {
        recursion(root, k);
        if(set.size() == k) return set.first();
        return -1;
    }

    private void recursion(TreeNode node, int k) {
        if(node == null) return;

        set.add(node.val);
        if(set.size() == k) set.pollFirst();


        if(node.left != null) kthLargest(node.left, k);
        if(node.right != null) kthLargest(node.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode((2));
        root.left.right = new TreeNode((4));
        root.left.left = new TreeNode((1));
        NthMaxValue nthMaxValue = new NthMaxValue();
        int result = nthMaxValue.kthLargest(root, 3);
        System.out.println(result);
        StringBuilder sb = new StringBuilder(10);
    }
}
