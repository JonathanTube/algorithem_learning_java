package educative.stack.sort;

class CheckSort {
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        Stack<Integer> temp = new Stack<>(stack.getCurrentSize());
        while (!stack.isEmpty()) {
            Integer val1 = stack.pop();
            if (temp.isEmpty()) {
                temp.push(val1);
                continue;
            }

            Integer val2 = temp.top();
            if (val1 >= val2) {
                temp.push(val1);
            } else {
                while (!temp.isEmpty() && temp.top() > val1) {
                    stack.push(temp.pop());
                }
                temp.push(val1);
            }
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<Integer>(7);
        stack.push(2);
        stack.push(97);
        stack.push(4);
        stack.push(42);
        stack.push(12);
        stack.push(60);
        stack.push(23);
        sortStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}