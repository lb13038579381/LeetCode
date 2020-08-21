package 数组;

public class 整数拆分 {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(fun(10));
    }

    private static int fun(int n) {

        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];

    }
}
