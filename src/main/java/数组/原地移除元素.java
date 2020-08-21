package 数组;

import java.util.Arrays;

public class 原地移除元素 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 4, 5, 6, 7,7,7, 8};
        int k = 7;
        System.out.println(Arrays.toString(fun(nums, k)));
    }

    public static int[] fun(int[] nums, int k) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != k) {
                nums[p] = nums[i];
                p++;
            }
        }
        System.out.println(p);
        return Arrays.copyOfRange(nums,0,p);
    }
}
