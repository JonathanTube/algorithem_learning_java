package leetcode.stack;


import java.util.Stack;

public class MonotonousStack {
    public int[] nextGreaterElement(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n ; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            stack.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        MonotonousStack monotonousStack = new MonotonousStack();
        int[] arr = monotonousStack.nextGreaterElement(new int[]{3,4,1,2,8});
        for (int val: arr) {
            System.out.print(val + "->");
        }
    }
}
