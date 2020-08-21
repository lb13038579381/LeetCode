package 数组;

/**
 * @description:
 * @author: lb
 * @time: 2020/7/17 3:10 下午
 */
public class 机器人路径 {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}
        };
        System.out.println(fun(nums));
        System.out.println(uniquePaths(6, 5));
        System.out.println(fun1(nums));
    }

    /**
     * @description:
     * @params: [nums]
     * @return: int
     * @author: lb
     * @time: 2020/7/17 3:10 下午
     */
    private static int fun(int[][] nums) {
        int[][] dp = new int[nums.length][nums[0].length];
        //第一行和第一列都为1
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < nums[0].length; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[nums.length - 1][nums[0].length - 1];

    }

    //有障碍物
    public static int fun1(int[][] nums) {
        int[][] dp = new int[nums.length][nums[0].length];
        dp[0][0] = nums[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i][0] == 1 || nums[i - 1][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < nums[0].length; i++) {
            if (nums[0][i] == 1 || nums[0][i - 1] == 1) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums[0].length; j++) {
                if (nums[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[nums.length - 1][nums[0].length - 1];
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
