package leetcode.stack;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树遍历-使用栈迭代方式-后序遍历
 * <p>
 * 设计思路是：先序遍历有了，中左右，代码的入栈右子树 和 入栈左子树，颠倒； 然后顺序是：中右左，放入链表后，链表做一次reverse变为左右中
 * 5
 * /    \
 * 4      6
 * / \    /  \
 * 2   1  NULL NULL
 * <p>
 * [2, 1, 4, 6, 5]
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
public class BinaryTreeTraverseBackWithStack {
    public List<Integer> traverse(TreeNode head) {
        if (head == null) return new ArrayList<>(0);

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(head); // 放入根节点
        while (!stack.isEmpty()) {
            // 出栈
            TreeNode treeNode = stack.pop();
//            if (treeNode == null) continue;// 这里为什么要判断，因为左右节点可能为空
            list.add(treeNode.val);
            // 每次pop完，都需要把右和左放入,如果这里判断一下左右，不为空才放入
            if (treeNode.left != null) stack.push(treeNode.left);
            if (treeNode.right != null) stack.push(treeNode.right);
        }

        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        // 5，4， 2， 1 ，6
        BinaryTreeTraverseBackWithStack binaryTreeTraverseFirstWithStack = new BinaryTreeTraverseBackWithStack();
        binaryTreeTraverseFirstWithStack.traverse(root).forEach(item -> System.out.print(item + "-"));
        Stack<Integer> stack = new Stack<>();
    }
}
