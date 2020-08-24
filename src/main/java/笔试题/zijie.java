package 笔试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zijie {
    public static void main(String[] args) {
        int n = 2;
        int l = 1;
        int r = 3;
        System.out.println(fun1(n, l, r));


    }

    //输入三个整数 n l r
//其中n表示从l到r中的所有子数组和为n并且能被3整除
    private static List<List<Integer>> fun1(int n, int l, int r) {
        List<List<Integer>> res = new ArrayList<>();
        helper(l, new ArrayList<>(), res, r, n, l);

        return res;
    }

    private static void helper(int first, ArrayList<Integer> cur, List<List<Integer>> res, int r, int n, int l) {
        if (cur.size() == n) {
            int sum = 0;
            for (Integer integer : cur) {
                sum += integer;
            }
            if (sum % 3 == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = first; i <= r; i++) {
            cur.add(i);
            for (int j = i; j < r; j++) {
                if (j != l) {
                    l = j;
                    break;
                }
            }
            helper(l, cur, res, r, n, l);
            cur.remove(cur.size() - 1);
        }
    }
}
