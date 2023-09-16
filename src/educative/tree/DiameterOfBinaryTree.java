package educative.tree;

import commons.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class DiameterOfBinaryTree {
    static int ans = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        return ans;
    }

    private static int recursion(TreeNode root){
        if(root == null) return 0;
        System.out.println("root.val=" + root.val);
        int left = recursion(root.left);
        System.out.println("   left=" + left);
        int right = recursion(root.right);
        System.out.println("   right=" + right);
    
        ans = Math.max(left + right, ans);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(5);
        diameterOfBinaryTree(root);
    }
}