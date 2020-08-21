package 数组;

public class 接雨水 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 100, 1, 2, 1, 3, 2, 1, 2, 1};
        System.out.println(fun(nums));
    }

    private static int fun(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] maxLeft = new int[nums.length];
        int[] maxRight = new int[nums.length];
        maxLeft[0] = 0;
        maxRight[nums.length - 1] = 0;
        for (int i = 1; i < nums.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i - 1]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i + 1]);
        }
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < maxLeft[i] && nums[i] < maxRight[i]){
                result += Math.min(maxLeft[i],maxRight[i]) - nums[i];
            }
        }
        return result;
    }
}
