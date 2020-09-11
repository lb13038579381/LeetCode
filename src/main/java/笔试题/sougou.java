package 笔试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class sougou {
    public static void main(String[] args) {
//        int a = 4;
//        int b = 4;
//        int c = 2;
//
//        System.out.println(fun(a, b, c));
//        int n = 2;
//        int[] nums = {-4, 2, 1, 3};
//        System.out.println(fun1(n, nums));
//
        String s = "53762";
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        System.out.println(fun2(s));
    }

    private static int fun2(String s) {
        List<List<Integer>> all = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                temp.add(j);
            }
            all.add(temp);
        }
        List<String> ans = new ArrayList<>();
        help(0, new ArrayList<Integer>(), all, ans, s);
        int res = 0;
        for (String an : ans) {
            if (canSucess(an, s)) {
                System.out.println(an);
                res++;
            }
        }
        System.out.println(res);
        return ans.size();
    }

    private static boolean canSucess(String news, String s) {
        if(news.equals(s)) {
            return false;
        }
        for (int i = 1; i < news.length(); i++) {
            double newc = news.charAt(i - 1) - '0';
            double oldc = s.charAt(i) - '0';
            double now = news.charAt(i) - '0';
            double t = newc + oldc;
            if (t % 2 == 0) {
                if (now != t / 2) {
                    return false;
                }
            } else {
                if (now != t / 2 + 0.5 && now != t / 2 - 0.5) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void help(int first, ArrayList<Integer> cur, List<List<Integer>> all, List<String> res, String s) {
        if (cur.size() == s.length()) {
            StringBuilder sb = new StringBuilder();
            cur.forEach(sb::append);
            res.add(sb.toString());
            return;
        }
        for (int i = first; i < all.size(); i++) {
            List<Integer> temp = all.get(i);
            for (int j = 0; j < temp.size(); j++) {
                cur.add(temp.get(j));
                help(i + 1, cur, all, res, s);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private static int fun1(int n1, int[] xa1) {
        double n = n1;
        double[] xa = new double[xa1.length];
        for (int i = 0; i < xa1.length; i++) {
            xa[i] = xa1[i];
        }
        double[] nums = new double[xa.length];
        for (int i = 0; i < xa.length; i += 2) {
            nums[i] = xa[i] - xa[i + 1] / 2;
            nums[i + 1] = xa[i] + xa[i + 1] / 2;
        }
        int res = 2;
        for (int i = 1; i < nums.length - 1; i += 2) {
            if (nums[i + 1] - nums[i] >= n) {
                res += 2;
            }

        }
        System.out.println(Arrays.toString(nums));
        return res;
    }

    private static int fun(int a, int b, int c) {
        int[] nums = new int[]{a, b, c};
        Arrays.sort(nums);
        int max1 = nums[2];
        int max2 = nums[1];
        int temp = (((max1 - max2) / 3 + max2) - nums[0]) / 2;
        nums[0] += temp;
        System.out.println(Arrays.toString(nums));
        return nums[0];
    }
}
