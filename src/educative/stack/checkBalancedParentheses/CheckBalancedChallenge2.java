package educative.stack.checkBalancedParentheses;

class CheckBalancedChallenge2 {
    public static boolean isBalanced(String exp) {
        // Write -- Your -- Code
        Stack<Character> stack = new Stack<>(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            if ('{' == exp.charAt(i)) {
                stack.push('}');
                continue;
            }
            if ('[' == exp.charAt(i)) {
                stack.push(']');
                continue;
            }
            if ('(' == exp.charAt(i)) {
                stack.push(')');
                continue;
            }
            if (stack.isEmpty()) return false;
            char val = stack.top();
            System.out.println("val=" + val + " num=" + exp.charAt(i));
            if (val == exp.charAt(i)) {
                stack.pop();
            } else return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        System.out.println(isBalanced("{[({})]}"));
//        System.out.println(isBalanced("{[({})]}}"));
        System.out.println(isBalanced("{[({})]("));
    }
}