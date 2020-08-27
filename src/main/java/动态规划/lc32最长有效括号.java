package 动态规划;

import java.util.Arrays;

public class lc32最长有效括号 {
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(fun(s));
    }

    private static int fun(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }
        if (s.length() == 2) {
            if (s.charAt('0') == '(' && s.charAt(1) == ')') {
                return 2;
            } else {
                return 0;
            }
        }
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }

            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
}
