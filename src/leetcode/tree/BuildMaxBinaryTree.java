package leetcode.tree;

import commons.TreeNode;

public class BuildMaxBinaryTree {
    private static TreeNode buildTree(int[] nums, int left, int right) {
        if(left > right) return null;
        int maxValueIndex = getMaxValueIndex(nums, left, right);

//        int maxValueIndex = left;
//        int maxVal = 0;
//        for(int i = left; i <= right; i++) {
//            if(nums[i] > maxVal) {
//                maxVal = nums[i];
//                maxValueIndex = i;
//            }
//        }

        TreeNode node = new TreeNode(nums[maxValueIndex]);
        node.left = buildTree(nums, left, maxValueIndex - 1);
        node.right = buildTree(nums, maxValueIndex + 1, right);
        return node;
    }

    private static int getMaxValueIndex(int[] nums, int left, int right) {
        int maxValue = nums[left];
        int maxValueIndex = left;
        for(int i = left + 1; i <= right; i++) {
            if(nums[i] <= maxValue) continue;
            maxValue = nums[i];
            maxValueIndex = i;
        }
        return maxValueIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        TreeNode treeNode = buildTree(nums, 0, nums.length - 1);
        if (treeNode != null) treeNode.printTree();
    }
}
