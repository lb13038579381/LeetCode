package 回溯;

import java.util.ArrayList;
import java.util.List;

public class n数之和 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 6, 3, 3, 43, 42, 343, 4 , 33, 3, 2, 1, 1, 2};
        int k = 10;
        for (List<Integer> fun : fun(nums, 10)) {
            System.out.println(fun);
        }

    }

    private static List<List<Integer>> fun(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, k, nums, new ArrayList<Integer>(), res);
        return res;
    }

    private static void dfs(int first, int k, int[] nums, ArrayList<Integer> cur, List<List<Integer>> res) {
        int sum = cur.stream().mapToInt(o -> o).sum();
        if (sum == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if(sum > k) {
            return;
        }
        for (int j = first; j < nums.length; j++) {
            cur.add(nums[j]);
            dfs(j + 1, k, nums, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
