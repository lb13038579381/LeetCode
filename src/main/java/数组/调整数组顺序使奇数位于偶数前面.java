package 数组;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 13, 11, 9, 8};
        System.out.println(Arrays.toString(fun(nums)));
    }

    private static int[] fun(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (nums[left] % 2 == 1 && left < right) {
                left++;
            }
            while (nums[right] % 2 == 0 && right > left) {
                right--;
            }
            if (nums[left] % 2 == 0 && nums[right] % 2 == 1) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }
}
