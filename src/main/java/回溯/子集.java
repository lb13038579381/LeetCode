package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 子集 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            helper(0, i, new ArrayList<Integer>(), res, nums);
        }
        System.out.println(res);
    }

    private static void helper(int first, int i, ArrayList<Integer> cur, List<List<Integer>> res, int[] nums) {
        if (cur.size() == i) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int j = first; j < nums.length; j++) {
            cur.add(nums[j]);
            helper(j + 1, i, cur, res, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
