package 数组;

import java.util.Arrays;

/**
 * @description:
 * @author: lb
 * @time: 2020/7/17 4:18 下午
 */
public class 除自身以外数组的乘积 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(fun(nums)));
    }
    public static int[] fun(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length-1] = 1;
        for(int i = 1;i < nums.length;i++) {
            left[i] = nums[i-1] * left[i-1];
        }
        for(int i = nums.length-2;i>=0;i--) {
            right[i] = nums[i+1] * right[i+1];
        }
        for(int i = 0;i<nums.length;i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}
