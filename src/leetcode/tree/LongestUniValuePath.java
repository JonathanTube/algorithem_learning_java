package leetcode.tree;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LongestUniValuePath {
    int res = 0;
    public int longestUniValuePath(TreeNode root) {
        if(root == null) return res;
        int left = longestUniValuePath(root.left);
        int right = longestUniValuePath(root.right);
        // 如果左边节点不为空，并且等于当前值
        if(root.left != null && root.left.val == root.val) {
            left += 1; // 左边值加1
        }else {
            left = 0;// 左边数位空,后者值不等于
        }
        if(root.right != null && root.right.val == root.val) {
            right +=  1;
        }else {
            right = 0;
        }
        // 将最大的路径存储起来
        res = Math.max(res, left + right);
        return res - 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        LongestUniValuePath longestUniValuePath =  new LongestUniValuePath();
        System.out.println(longestUniValuePath.longestUniValuePath(root));
    }
}
