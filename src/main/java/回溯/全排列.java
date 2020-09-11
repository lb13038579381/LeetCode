package 回溯;

import java.util.*;

public class 全排列 {
    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        StringBuilder sb = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("aa");
        sb.append("aaa");
        System.out.println(fun(num));
    }


    private static List<List<Integer>> fun(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int num : nums) {
            cur.add(num);
        }
        helper(0, nums.length, res, new ArrayList<>(), nums);
        return res;
    }

    private static void helper(int first, int k, List<List<Integer>> res, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int j = first; j < nums.length; j++) {
            cur.add(nums[j]);
            helper(first + 1, k, res, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }

}
