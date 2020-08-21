package 其他;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间 {
    public static void main(String[] args) {
        int[][] a = {
                {0, 2},
                {5, 10},
                {13, 23},
                {24, 25}
        };
        int[][] b = {
                {1, 5},
                {8, 12},
                {15, 24},
                {25, 26}
        };
        for (int[] c : fun(a, b)) {
            System.out.println(Arrays.toString(c));
        }
    }

    private static int[][] fun(int[][] a, int[][] b) {
        int left = 0;
        int right = 0;
        List<int[]> res = new ArrayList<>();
        while (left < a.length && right < b.length) {
            int l = Math.max(a[left][0], b[right][0]);
            int r = Math.min(a[left][1], b[right][1]);
            if (l <= r) {
                res.add(new int[]{l, r});
            }
            if (a[left][1] < b[right][1]) {
                left++;
            } else {
                right++;
            }
        }
        int[][] result = new int[res.size()][2];
        int k = 0;
        for (int[] re : res) {
            result[k] = re;
            k++;
        }
        return result;
    }
}
