package 其他;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 机器人的活动范围 {
    public static void main(String[] args) {
        int m = 4;
        int n = 6;
        int k = 15;
        System.out.println(fun(m, n, k));
    }

    private static int fun(int m, int n, int k) {
        int[][] marked = new int[m][n];
        int temp = 3;
        int i1 = 0;
        int j1 = 0;
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        marked[0][0] = 1;
        if (k == 0) {
            return 1;
        }
        result++;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int i = t[0];
            int j = t[1];
            //向右
            if (i < m && j + 1 < n && sum(i, j + 1) <= k && marked[i][j + 1] == 0) {
                q.offer(new int[]{i, j + 1});
                marked[i][j + 1] = 1;
                result++;
            }
            //向下
            if (j < n && i + 1 < m && sum(i + 1, j) <= k && marked[i + 1][j] == 0) {
                q.offer(new int[]{i + 1, j});
                marked[i + 1][j] = 1;
                result++;
            }
        }
        for (int[] ints : marked) {
            System.out.println(Arrays.toString(ints));
        }
        return result;
    }

    private static int sum(int i, int j) {
        int res = 0;
        System.out.print(i + " " + j);
        while (i > 0) {
            res += i % 10;
            i = i / 10;
        }
        while (j > 0) {
            res += j % 10;
            j = j / 10;
        }
        System.out.print(" " + res);
        System.out.println();
        return res;
    }
}
