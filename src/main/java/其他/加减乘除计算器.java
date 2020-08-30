package 其他;

import java.util.Stack;

public class 加减乘除计算器 {
    public static void main(String[] args) {
        String s = "123+456-222+444*100/20-200+100/10/20+20";
        System.out.println(fun(s));
    }

    private static int fun(String s) {
        int n = 0;
        int temp = 0;
//        boolean haschu = false;
//        Stack<Object> stack = new Stack<>();
//        for (int i =0; i < s.length(); i++) {
//            if (Character.isDigit(s.charAt(i))) {
//                temp += Math.pow(10, n) * (s.charAt(i) - '0');
//                n++;
//            } else {
//                if (n != 0) {
//                    stack.push(temp);
//                    n = 0;
//                    temp = 0;
//                }
//                if(haschu) {
//
//                }
//                if (s.charAt(i) == '/') {
//                    haschu = true;
//                }
//            }
//
//        }
        return 1;
    }
}
