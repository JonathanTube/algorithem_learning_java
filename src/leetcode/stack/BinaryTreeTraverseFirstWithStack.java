package leetcode.stack;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树遍历-使用栈迭代方式-前序遍历
 *         5
 *      /     \
 *     4       6
 *    / \    /   \
 *  2    1  NULL NULL
 *
 * [5, 4, 2, 1, 6]
 * stack = []
 * stack = [5]
 * stack = []; list = [5];
 * stack = [6,4]; list = [5];
 * stack = [6]; list = [5,4]
 * stack = [6,1,2]; list = [5,4]
 * stack = [6,1,null,null]; list = [5,4,2]
 * stack = [6,1,null]; list = [5,4,2]
 * stack = [6,1]; list = [5,4,2]
 * stack = [6,null,null]; list = [5,4,2,1]
 * stack = [6,null]; list = [5,4,2,1]
 * stack = [6]; list = [5,4,2,1]
 * stack = []; list = [5,4,2,1,6]
 */
public class BinaryTreeTraverseFirstWithStack {
    public List<Integer> traverse(TreeNode head) {
        if (head == null) return new ArrayList<>(0);

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(head); // 放入根节点
        while (!stack.isEmpty()) {
            // 出栈
            TreeNode treeNode = stack.pop();
            if (treeNode == null) continue;
            list.add(treeNode.val);
            // 每次pop完，都需要把右和左放入
            stack.push(treeNode.right);
            stack.push(treeNode.left);
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        // 5，4， 2， 1 ，6
        BinaryTreeTraverseFirstWithStack binaryTreeTraverseFirstWithStack = new BinaryTreeTraverseFirstWithStack();
        binaryTreeTraverseFirstWithStack.traverse(root).forEach(item -> System.out.print(item + "-"));
    }
}
