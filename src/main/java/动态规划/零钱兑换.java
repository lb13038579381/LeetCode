package 动态规划;

import java.util.Arrays;
import java.util.List;

public class 零钱兑换 {
    public static void main(String[] args) {

        int[] amount = {186, 419,83,408};
        int k = 6249;
        System.out.println(fun(amount, k));
    }

    private static int fun(int[] amount, int k) {
        int[] dp = new int[k + 1];
        dp[0] = 0;
        for (int i = 1; i <= k; i++) {
            int curMin = Integer.MAX_VALUE;
            for (int j = 0; j < amount.length; j++) {
                if (amount[j] <= i && dp[i - amount[j]] < curMin) {
                    curMin =dp[i - amount[j]]+ 1;
                }
            }
            dp[i] = curMin;
        }
        return dp[k]==Integer.MAX_VALUE?-1:dp[k];
    }
}
