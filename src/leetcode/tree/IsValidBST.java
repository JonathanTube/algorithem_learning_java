package leetcode.tree;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        // 第一个节点设置边界为Long类型的最大最小值
        // 为什么是long?因为测试用例值可能为Integer的最大最小值
        // 需要找一个比Integer最小值更小,最大值更大的区间
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode node, long left, long right) {
        if(node == null) return true;
        System.out.println(String.format("node.val=%s", node.val));
        // 中序遍历: 中-左-右
        // 判断当前节点的值是否在区间内
        if(node.val <= left || node.val >= right) return false;
        return dfs(node.left, left, node.val) && dfs(node.right, node.val, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left= new TreeNode(3);
        root.right.right = new TreeNode(6);
        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(root));
    }
}
