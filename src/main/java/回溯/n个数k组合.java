package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n个数k组合 {
    public static void main(String[] args) {
        int n = 4;
        int k = 4;
        for (List<Integer> fun : fun(n, k)) {
            System.out.println(fun);
        }
        System.out.println(fun(n, k));
    }

    private static List<List<Integer>> fun(int n, int k) {
        if (k > n) {
            return null;
        }
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(0, k, new ArrayList<>(), res, nums);
        return res;

    }

    private static void helper(int first, int k, ArrayList<Integer> cur, List<List<Integer>> res, int[] nums) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int j = first; j < nums.length; j++) {
            cur.add(nums[j]);
            helper(j + 1, k, cur, res, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
