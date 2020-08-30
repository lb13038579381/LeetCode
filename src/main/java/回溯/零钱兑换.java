package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 零钱兑换 {
    static         int all = 0;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        int n = 50;
        List<List<Integer>> res = new ArrayList<>();
        helper(0, new ArrayList<>(), res, n, nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
        System.out.println(all);
    }

    private static void helper(int first, ArrayList<Integer> cur, List<List<Integer>> res, int n, int[] nums) {
        if (cur.stream().mapToInt(o -> o).sum() == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (cur.stream().mapToInt(o -> o).sum() > n) {
            return;
        }
        for (int j = first; j < nums.length; j++) {
            cur.add(nums[j]);
            helper(j, cur, res, n, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
