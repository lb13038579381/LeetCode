package 字符串;

import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 回文子串 {
    public static void main(String[] args) {
        String str = "abcdccdcb";
        System.out.println(fun(str));
    }

    private static List<String> fun(String str) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < str.length() + 1; i++) {
            helper(0, i, new ArrayList<Character>(), res, str);
        }
        return res;
    }

    private static void helper(int start, int i, ArrayList<Character> cur, List<String> res, String str) {
        if (cur.size() == i) {
            if (ishuiwen(cur)) {
                String temp = "";
                for (Character character : cur) {
                    temp += character;
                }
                res.add(temp);
            }
            return;
        }
        for (int j = start; j < str.length(); j++) {
            cur.add(str.charAt(j));
            helper(j + 1, i, cur, res, str);
            cur.clear();
        }

    }

    private static boolean ishuiwen(ArrayList<Character> cur) {
        int l = 0;
        int r = cur.size() - 1;
        while (l < r) {
            if (!cur.get(l).equals(cur.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static int countSubstrings(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int count = length;
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else if (i + 1 == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}