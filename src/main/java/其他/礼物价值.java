package 其他;

public class 礼物价值 {
    public static void main(String[] args) {
        int[][] nums = {
                {
                        1, 3, 1
                },
                {
                        1, 5, 1
                },
                {
                        4, 2, 1
                }
        };
        System.out.println(fun(nums));
    }

    private static int fun(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = nums[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + nums[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + nums[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + nums[i][j];
            }
        }
        return dp[m-1][n-1];

    }

}
 class xx{
    int a;
    public xx(int a) {
        this.a = a;
    }
}
