package 数组;

import java.util.Arrays;
/*
1594916528749
 */
public class 排序数组去重 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,4,5,5,5,6,7,8};
        System.out.println(Arrays.toString(fun(nums)));
    }
    public static int[] fun(int[] nums) {
        int p = 0;
        for(int i = 0;i<nums.length;i++) {
            if(nums[p] != nums[i]) {
                p++;
                nums[p] = nums[i];
            }
        }
        return nums;
    }
}
