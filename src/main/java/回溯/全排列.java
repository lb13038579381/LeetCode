package 回溯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 全排列 {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
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
        helper(0, nums.length, res, cur, nums);
        return res;
    }

    private static void helper(int first, int k, List<List<Integer>> res, List<Integer> cur, int[] nums) {
        if (first == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int j = first; j < nums.length; j++) {
            Collections.swap(cur, j, first);
            helper(first + 1, k, res, cur, nums);
            Collections.swap(cur, j, first);
        }
    }

}
