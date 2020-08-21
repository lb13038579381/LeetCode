package 字符串;

import java.util.ArrayList;
import java.util.List;

public class 替换空格 {
    public static void main(String[] args) {
        String s = "hello xx world";
        System.out.println(fun(s));
    }

    private static String fun(String s) {
        if (!s.contains(" ")) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append('%');
                stringBuilder.append('2');
                stringBuilder.append('0');
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();

    }
}
