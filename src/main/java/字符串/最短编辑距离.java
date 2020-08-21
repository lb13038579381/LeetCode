package 字符串;

import javax.security.sasl.SaslServer;
import java.util.Arrays;

public class 最短编辑距离 {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        System.out.println(fun(s1, s2));
    }

    private static int fun(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i < s2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[l1][l2];
    }
}
