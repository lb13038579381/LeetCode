package 回溯;

import java.util.Arrays;

public class lc60第k个排列 {
    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        System.out.println(fun(n, k));
    }

    static String res = "";
    static boolean hasEnd = false;
    static int k;

    private static String fun(int n, int k1) {
        k = k1;
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        dfs(0, nums);
        return res;
    }

    private static void dfs(int first, int[] nums) {
        if (!hasEnd) {
            if (first == nums.length) {
                if (--k == 0) {
                    for (int num : nums) {
                        res += num;
                    }
                    hasEnd = true;
                }
                return;
            }
            for (int j = first; j < nums.length; j++) {
                swap(nums, j, first);
                dfs(first + 1, nums);
                swap(nums, j, first);
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
