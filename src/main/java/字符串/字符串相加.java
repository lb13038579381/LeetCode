package 字符串;

import java.util.Stack;

public class 字符串相加 {
    public static void main(String[] args) {
        String a = "99999";
        String b = "99999";
        System.out.println(fun(a, b));
    }

    private static String fun(String a, String b) {

        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();
        Stack<Character> as = new Stack<>();
        Stack<Character> bs = new Stack<>();
        for (char achar : achars) {
            as.push(achar);
        }
        for (char bchar : bchars) {
            bs.push(bchar);
        }
        Stack<Integer> res = new Stack<>();
        int p = 0;
        while (!as.isEmpty() || !bs.isEmpty()) {
            if (!as.isEmpty()) {
                p += as.pop() - '0';
            }
            if (!bs.isEmpty()) {
                p += bs.pop() - '0';
            }
            res.push(p % 10);
            p = p / 10;
        }
        if(p != 0){
            res.push(p);
        }
        StringBuilder result = new StringBuilder();
        while(!res.isEmpty()) {
            result.append(res.pop());
        }
        return result.toString();


    }
}
