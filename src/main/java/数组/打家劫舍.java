package 数组;

public class 打家劫舍 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(fun(nums));
    }

    private static int fun(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i =2;i<nums.length;i++){
            dp[i] = Math.max(nums[i] + dp[i-2],dp[i-1]);
        }
        return dp[dp.length-1];
    }
}
