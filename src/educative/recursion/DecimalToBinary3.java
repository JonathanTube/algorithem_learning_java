package educative.recursion;

import educative.stack.sort.Stack;

class DecimalToBinary3 {
    private static Stack<Integer> stack = new Stack<>(20);
    public static int decimalToBinary(int n) {
        System.out.println(stack);
        if(n == 0 || n == 1) return n;
        int prev = decimalToBinary(n / 2) * 10;
        stack.push(prev);
        int remainder = n % 2;
        return  prev + remainder;
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(16));
    }
}