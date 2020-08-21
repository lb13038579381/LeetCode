package 数组;

import java.util.ArrayList;
import java.util.List;

/*
1594920753266
 */
public class 螺旋打印矩阵 {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        System.out.println(fun(nums));
    }
/**
 *
 *
 * @description:

 * @return:
 * @author: lb
 * @time: 2020/7/17 3:05 下午
 */
    /**
     * @description:
     * @params:
     * @return:
     * @author: lb
     * @time: 2020/7/17 3:07 下午
     */
    private static List<Integer> fun(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        int rows = nums.length;
        if (rows == 0)
            return list;
        int colms = nums[0].length;

        int left = 0;
        int right = colms - 1;
        int top = 0;
        int down = rows - 1;
        while (top <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(nums[top][i]);
            }
            for (int j = top + 1; j <= down; j++)
                list.add(nums[j][right]);
            if (top != down) {
                for (int k = right - 1; k >= left; k--)
                    list.add(nums[down][k]);
            }
            if (right != left) {
                for (int m = down - 1; m >= top + 1; m--)
                    list.add(nums[m][left]);
            }
            left++;
            right--;
            top++;
            down--;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return list;
    }
}

