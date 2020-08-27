package 字符串;

import java.util.LinkedList;
import java.util.Queue;

public class LC79单词搜索 {
    public static void main(String[] args) {
        char[][] nums = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(fun(nums, "ABCB"));
    }

    private static boolean fun(char[][] nums, String s) {
        int col = nums[0].length;
        int cow = nums.length;
        for (int i = 0; i < cow; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0, s, nums)) {
                    return true;
                }
            }
        }
        return false;

    }
static  boolean res = false;
    private static boolean dfs(int i, int j, int cur, String s, char[][] nums) {
        if (cur == s.length()) {
            res = true;
            return true;
        }
        if (i < 0 || j < 0 || i >= nums.length || j >= nums[0].length || nums[i][j] != s.charAt(cur)) {
            return false;
        }
        if (!res) {
            char c = nums[i][j];
            nums[i][j] = '.';
            boolean res2 = dfs(i + 1, j, cur + 1, s, nums);
            boolean res1 = dfs(i - 1, j, cur + 1, s, nums);
            boolean res4 = dfs(i, j + 1, cur + 1, s, nums);
            boolean res3 = dfs(i, j - 1, cur + 1, s, nums);
            nums[i][j] = c;
            return res1 || res2 || res3 || res4;
        } else {
            return true;
        }

    }
}
