package 字符串;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 移除括号 {
    public static void main(String[] args) {
        String str = "(a(b(c)d)";
        System.out.println(fun(str));
    }

    private static String fun(String str) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0;i < str.length();i++) {
            char c = str.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            if(c == ')') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }else{
                    temp.add(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < str.length();i++) {
            if(!temp.contains(i) && !stack.contains(i)) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
