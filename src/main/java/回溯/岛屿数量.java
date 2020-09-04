package 回溯;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 岛屿数量 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String te = sc.next();
        int m = Integer.parseInt(te.split(",")[0]);
        int n = Integer.parseInt(te.split(",")[1]);
        char[][] nums = new char[m][n];
        for (int i = 0; i < m; i++) {
            String temp = sc.next();
            nums[i] = temp.toCharArray();
        }
        Deque<int[]> queue = new LinkedList<>();
        int res = 0;
        int[][] marked = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j] == 'S' && marked[i][j] == 0) {
                    marked[i][j] =1;
                    queue.offer(new int[]{i, j});
                    res++;
                    while (!queue.isEmpty()) {
                        int[] t = queue.poll();
                        int i1 = t[0];
                        int j1 = t[1];
                        if (i1 - 1 >= 0 && nums[i1 - 1][j1] == 'S' && marked[i1 - 1][j1] == 0) {
                            queue.offer(new int[]{i1 - 1, j1});
                            marked[i1 - 1][j1] = 1;
                        }
                        if (i1 + 1 < m && nums[i1 + 1][j1] == 'S' && marked[i1 + 1][j1] == 0) {
                            queue.offer(new int[]{i1 + 1, j1});
                            marked[i1 + 1][j1] = 1;
                        }
                        if (j1 - 1 >= 0 && nums[i1][j1 - 1] == 'S' && marked[i1][j1 - 1] == 0) {
                            queue.offer(new int[]{i1, j1 - 1});
                            marked[i1][j1 - 1] = 1;
                        }
                        if (j1 + 1 < n && nums[i1][j1 + 1] == 'S' && marked[i1][j1 + 1] == 0) {
                            queue.offer(new int[]{i1, j1 + 1});
                            marked[i1][j1 + 1] = 1;
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
}
