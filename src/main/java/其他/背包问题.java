package 其他;

import java.util.Arrays;

public class 背包问题 {
    public static void main(String[] args) {
        int[] weight = {2, 10, 5, 3, 4, 5, 6};
        int[] value = {5, 6, 3, 2, 2, 3, 4};
        int k = 10;
        int m = 3;
        System.out.println(fun(weight, value, k, m));
        BackPack_Solution(k, m, weight, value);
    }

    private static int fun(int[] weight, int[] value, int k, int m) {
        int[][] dp = new int[m + 1][k + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (weight[i] > k) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][k - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));

        }
        return -1;
    }

    public static int[][] BackPack_Solution(int jiazhi, int shuliang, int[] weight, int[] value) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int dp[][] = new int[shuliang + 1][jiazhi + 1];
        for (int i = 0; i < shuliang + 1; i++)
            dp[i][0] = 0;
        for (int j = 0; j < jiazhi + 1; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= shuliang; i++) {
            for (int j = 1; j <= jiazhi; j++) {
                if (j >= weight[i])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }


        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp;
    }
}
