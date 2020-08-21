package 字符串;

import java.util.Stack;

public class 有效括号 {
    public static void main(String[] args) {
        String s = "()[]{([([{}";
        System.out.println(fun(s));
    }

    private static boolean fun(String s) {
        if(s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
