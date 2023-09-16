package leetcode.stack;

import java.util.Stack;

class BasicCalculator {
    public int calculate(String s) {
        int len = s.length();
        // 字符串中包含空格，如何过滤掉？
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char prevOp = '+';

        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 判断字符是否数字, 因为每次只能取一个字符，
            if(Character.isDigit(c)) {
                // 如果数字是两位，那就凉了，所以要累加
                // 前一个乘以10 + 当前的
                // 这里记住，直接减去'0'得到数字
                num = num * 10 + (c - '0');
            }

            if (!Character.isDigit(c) && c != ' ' || i == len - 1) {
                switch(prevOp) {
                    case '+' :
                        stack.push(num);
                        break;
                    case '-' :
                        stack.push(-num);
                        break;
                    case '*' :
                        stack.push(stack.pop() * num);
                        break;
                    case '/' :
                        stack.push(stack.pop() / num);
                        break;
                }
                prevOp = c;
                num = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty()) result += stack.pop();
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();
//        String str = " 3+5 / 2 ";
        String str = " 3/2 ";
        int result = basicCalculator.calculate(str);
        System.out.println("result=" + result);
    }
}