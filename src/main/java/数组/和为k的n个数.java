package 数组;

import java.util.ArrayList;
import java.util.List;

public class 和为k的n个数 {
    public static void main(String[] args) {
        int k = 7;
        int n = 3;
        List<List<Integer>> res = new ArrayList<>();
        fun(n, k, 1, new ArrayList<Integer>(), res);
        System.out.println(res);
    }

    private static void fun(int n, int k, int start, ArrayList<Integer> path, List<List<Integer>> res) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (k - i < 0) {
                break;
            }
            path.add(i);
            fun(n-1, k-i, i + 1, path, res);
            path.remove(path.size() - 1);
        }

    }
}
