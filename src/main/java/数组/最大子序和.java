package 数组;

import java.util.ArrayList;
import java.util.HashMap;

public class 最大子序和 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(fun(nums));
    }

    private static int fun(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        for(int i = 1;i < nums.length;i++) {
//            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
//        }
//        int max = Integer.MIN_VALUE;
//        for (int i : dp) {
//            if(i > max){
//                max = i;
//            }
//        }
//        return max;
        int res = 0;
        int sum = 0;
        for (int num : nums) {
            if(sum > 0) {
                sum += num;
            }else{
                sum = num;
            }
            res = Math.max(sum,res);
        }
        return res;
    }
}
