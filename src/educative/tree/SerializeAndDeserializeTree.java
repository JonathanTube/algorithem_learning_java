package educative.tree;

import commons.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node == null) {
                sb.append("none");
                continue;
            }
            if(sb.length() > 0) sb.append("-");
            sb.insert(0, node.val);
            if(node.right != null)  stack.push(node.right);
            else stack.push(null);
            if(node.left != null) stack.push(node.left);
            else stack.push(null);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(75);

        root.right = new TreeNode(200);
        root.right.right = new TreeNode(350);

        SerializeAndDeserializeTree sadr = new SerializeAndDeserializeTree();
        String str = sadr.serialize(root);
        System.out.println(str);
    }
}