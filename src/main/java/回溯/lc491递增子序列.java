package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc491递增子序列 {
    public static void main(String[] args) {
        int[] nums = {4, 6, 5, 7, 7, 8, 8};
        List<Integer> t = new ArrayList<>();
        t.add(6);
        t.add(6);
        System.out.println(isDiZeng(t));
        for (List<Integer> a : fun(nums)) {
            System.out.println(a);
        }
    }

    private static List<List<Integer>> fun(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 2; i < nums.length; i++) {
            dfs(0, i, res, new ArrayList<Integer>(), nums);
        }
        return res;
    }

    private static void dfs(int first, int n, List<List<Integer>> res, ArrayList<Integer> cur, int[] nums) {
        if (cur.size() == n) {
            if (isDiZeng(cur)) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int j = first; j < nums.length; j++) {
            if (j != first && nums[j] == nums[j - 1]) {
                continue;
            }
            cur.add(nums[j]);
            dfs(j + 1, n, res, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }

    private static boolean isDiZeng(List<Integer> cur) {
        for (int i = 0; i < cur.size() - 1; i++) {
            if (cur.get(i) > cur.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
