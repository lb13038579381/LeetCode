package 数组;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 和为s的连续子序列 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fun(9)));
    }

    private static int[][] fun(int s) {
        int left = 1;
        int right = 1;
        int sum = 0;
        List<int[]> result = new ArrayList<>();
        while (left < s / 2) {
            if (sum < s) {
                sum += right;
                right++;
            }
            if (sum > s) {
                sum -= left;
                left++;
            }
            if (sum == s) {
                int[] temp = new int[right - left];
                int p = 0;
                for (int i = left; i <= right - 1; i++) {
                    temp[p] = i;
                    p++;
                }
                p = 0;
                left++;
                right = left;
                result.add(temp);
                sum = 0;
            }
        }
        int[][] res = new int[result.size()][100];
        for(int i = 0;i < result.size();i++) {
            res[i] = result.get(i);
            System.out.println(Arrays.toString(res[i]));
        }
        return res;
    }
}
