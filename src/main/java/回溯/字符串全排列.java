package 回溯;

import java.util.*;

public class 字符串全排列 {
    public static void main(String[] args) {
        String str = "dkjphedy";
        System.out.println(fun(str));
    }

    private static List<String> fun(String str) {
        List<String> res = new ArrayList<>();
        List<Character> output = new ArrayList<>();
        for (char c : str.toCharArray()) {
            output.add(c);
        }
        helper(0, output, res, str.length());
        System.out.println(res.size());
        Set<String> strings = new HashSet<>(res);
        System.out.println(strings.size());
        
        return res;
    }

    private static void helper(int first, List<Character> output, List<String> res, int length) {
        if (first == length - 1) {
            StringBuilder sb = new StringBuilder();
            output.forEach(o -> sb.append(o));
                res.add(sb.toString());

        }
        for (int i = first; i < length; i++) {
            Collections.swap(output, first, i);
            helper(first + 1, output, res, length);
            Collections.swap(output, first, i);
        }
    }
}
