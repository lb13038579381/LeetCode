package 数组;

import domain.ListNode;
import org.apache.poi.ss.formula.functions.T;

import java.util.Arrays;

public class 最小路径和 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(fun(nums));

        ListNode a = (ListNode) getxx("listnode",ListNode.class);
        System.out.println(a);
    }
    public static Object getxx(String name,Class clazz) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if(name.equals("listnode")) {
            Object res = clazz.newInstance();
            return res;
        }else{
            Object res = clazz.newInstance();
            return res;
        }
    }

    private static int fun(int[][] nums) {
        int col = nums[0].length;
        int cow = nums.length;
        int[][] dp = new int[cow][col];
        dp[0][0] = nums[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + nums[0][i];
        }
        for (int i = 1; i < cow; i++) {
            dp[i][0] = dp[i - 1][0] + nums[i][0];
        }
        for (int i = 1; i < col; i++) {
            for (int j = 1; j < cow; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + nums[i][j];
            }
        }
        return dp[cow - 1][col - 1];
    }
}
