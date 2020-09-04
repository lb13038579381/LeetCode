package 其他;

import java.util.Stack;

public class lc1626计算器 {
    public static void main(String[] args) {
        String s = " 3+5 / 2 ";
        s = s.replace(" ","");
        System.out.println(s.replace(" ",""));
        System.out.println(fun(s));
    }

    private static int fun(String s) {
        Stack<Object> stack = new Stack<>();
        int i = 0;
        int p = 0;
        boolean hasNum = false;
        StringBuilder temp = new StringBuilder();
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    temp.append(s.charAt(i));
                    i++;
                }
                stack.push(Integer.valueOf(temp.toString()));
                temp = new StringBuilder();
            } else if (s.charAt(i) == '+') {
                i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    temp.append(s.charAt(i));
                    i++;
                }
                stack.push(Integer.valueOf(temp.toString()));
                temp = new StringBuilder();
            } else if (s.charAt(i) == '-') {
                i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    temp.append(s.charAt(i));
                    i++;
                }
                stack.push(Integer.parseInt(temp.toString()) * (-1));
                temp = new StringBuilder();
            } else if (s.charAt(i) == '*') {
                i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    temp.append(s.charAt(i));
                    i++;
                }
                stack.push((int) stack.pop() * Integer.valueOf(temp.toString()));
                temp = new StringBuilder();
            } else if (s.charAt(i) == '/') {
                i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    temp.append(s.charAt(i));
                    i++;
                }
                stack.push((int) stack.pop() / Integer.valueOf(temp.toString()));
                temp = new StringBuilder();
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += (int) stack.pop();
        }
        return res;
    }
}
