package 数组;

import domain.ListNode;

import java.util.LinkedList;
import java.util.Queue;

public class 岛屿数量 {
    public static void main(String[] args) {
        int[][] nums = {{'1', '1', '1'},
                {
                        '0', '1', '0'
                },
                {
                        '1', '1', '1'
                },
        };
        System.out.println(fun(nums));
    }

    private static int fun(int[][] nums) {
        int cows = nums.length;
        int cols = nums[0].length;
        int res = 0;
        for (int i = 0; i < cows; i++) {
            for (int j = 0; j < cols; j++) {
                if (nums[i][j] == '1') {
                    res++;
                    nums[i][j] = 0;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i * cols + j);
                    while (!queue.isEmpty()) {
                        int id = queue.remove();
                        int i1 = id / cols;
                        int j1 = id % cols;
                        if (i1 - 1 >= 0 && nums[i1 - 1][j1] == '1') {
                            queue.offer((i1 - 1) * cols + j1);
                            nums[i1 - 1][j1] = 0;
                        }
                        if (i1 + 1 < cows && nums[i1 + 1][j1] == '1') {
                            queue.offer((i1 + 1) * cols + j1);
                            nums[i1 + 1][j1] = 0;
                        }
                        if (j1 - 1 >= 0 && nums[i1][j1 - 1] == '1') {
                            queue.offer((i1 * cols + j1 - 1));
                            nums[i1][j1 - 1] = 0;
                        }
                        if (j1 + 1 < cols && nums[i1][j1 + 1] == '1') {
                            queue.offer((i1 * cols + j1 + 1));
                            nums[i1][j1 + 1] = 0;
                        }
                    }
                }
            }
        }
        return res;
    }
}
