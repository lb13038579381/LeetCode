package 其他;

import java.util.Stack;

class 计算器 {


    public static void main(String[] args) {
        String str = "123+456-(999-888)-100";
        System.out.println(caclu(str));
    }

    private static int caclu(String str) {
        Stack<Object> stack = new Stack<>();
        int n = 0;
        int temp = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (Character.isDigit(str.charAt(i))) {
                temp += (int) Math.pow(10, n) * (str.charAt(i) - '0');
                n++;
            } else if (str.charAt(i) != ' ') {
                if (n != 0) {
                    stack.push(temp);
                    temp = 0;
                    n = 0;
                }
                if (str.charAt(i) == '(') {
                    int curRes = helper(stack);
                    stack.pop();
                    stack.push(curRes);
                } else {
                    stack.push(str.charAt(i));
                }
            }
        }
        if (n != 0) {
            stack.push(temp);
        }
        return helper(stack);
    }

    private static int helper(Stack<Object> stack) {
        int res = 0;
        if (!stack.isEmpty()) {
            res += (int) stack.pop();
        }
        while (!stack.isEmpty() && (char) stack.peek() != ')') {
            if ((char) stack.peek() == '-') {
                stack.pop();
                res = res - (int) stack.pop();
            } else {
                stack.pop();
                res += (int) stack.pop();
            }
        }
        return res;
    }
}