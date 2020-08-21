package 笔试题;

import java.util.*;

public class 腾讯视野游戏 {
    static int res = Integer.MAX_VALUE;
    static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) {
        int l = 10;
        int[][] nums = {
                {1, 2},
                {3, 4},
                {5, 6},
                {6, 10},
                {2, 6},
                {0, 3},
                {5, 11}
        };

        System.out.println(fun(nums, l));
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int fun(int[][] nums, int l) {
        helper(0, new ArrayList<int[]>(), nums, l);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static void helper(int first, ArrayList<int[]> cur, int[][] nums, int l) {
        if (canSuccess(cur, l)) {
            res = Math.min(res, cur.size());
            result = new ArrayList<>(cur);
            return;
        }
        if (cur.size() >= res) {
            return;
        }
        for (int j = first; j < nums.length; j++) {
            cur.add(nums[j]);
            helper(j + 1, cur, nums, l);
            cur.remove(cur.size() - 1);
        }
    }

    private static boolean canSuccess(ArrayList<int[]> cur, int l) {
        Set<Integer> temp = new TreeSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] ints : cur) {
            for (int i = ints[0]; i <= ints[1]; i++) {
                temp.add(i);
                min = Math.min(i, min);
                max = Math.max(i, max);
            }
        }
        int count = 0;
        for (int i = 0; i < l + 1; i++) {
            if (temp.contains(i)) {
                count++;
            }else{
                return false;
            }
        }
        if(count == l+1) {
            return true;
        }
        return false;
    }
}
