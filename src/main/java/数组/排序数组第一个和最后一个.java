package 数组;

import java.util.Arrays;

public class 排序数组第一个和最后一个 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(fun(nums, 7)));
    }

    private static int[] fun(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = {-1, -1};
        if (nums.length == 1 && k == nums[0]) {
            return res;
        }
        res[0] = helper(nums, k, true);
        res[1] = helper(nums, k, false) - 1;
        return res;
    }

    private static int helper(int[] nums, int k, boolean isLeft) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] > k || (isLeft && nums[mid] == k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
