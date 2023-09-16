package educative.stack.checkBalancedParentheses;

class CheckBalancedChallenge {
    public static boolean isBalanced(String exp) {
        // Write -- Your -- Code
        Stack<Character> stack = new Stack<>(exp.length());
        for(int i = 0; i < exp.length(); i ++) {
            char ch = exp.charAt(i);
            if(ch == '{' || ch == '(' || ch == '[' ) stack.push(ch);
            else {
                char ch2 = stack.pop();
                if(ch == '}' && ch2 != '{') return false;
                if(ch == ')' && ch2 != '(') return false;
                if(ch == ']' && ch2 != '[') return false;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isBalanced("{}{}{}"));
    }
}