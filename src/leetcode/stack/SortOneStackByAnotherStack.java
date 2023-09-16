package leetcode.stack;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 */
public class SortOneStackByAnotherStack {

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            System.out.println("cur = " + cur);
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);

            print("stack", stack);
            print("help", help);
            System.out.println("\r\n");
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void print(String type, Stack<Integer> stack) {
        System.out.print(type + "=");
        Object[] arr = stack.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        sortStackByStack(stack);
        print("result=", stack);
    }
}
