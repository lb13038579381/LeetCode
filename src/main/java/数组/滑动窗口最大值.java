package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = {7,2,4};
        int k = 2;
        System.out.println(Arrays.toString(fun(nums, k)));
    }

    private static int[] fun(int[] nums, int k) {
        int left = 0;
        int right = left + k - 1;
        int max = Integer.MIN_VALUE;
        int r = 0;
        int[] res = new int[nums.length - k + 1];
        while (right < nums.length) {
            if (max < left) {
                max = left;
                for (int i = left; i <= right; i++) {
                    max = nums[max] < nums[i] ? i : max;
                }
            } else {
                max = nums[right] < nums[max] ? max : right;
            }
            left++;
            right++;
            res[r] = nums[max];
            r++;
        }
        return res;
    }
}
