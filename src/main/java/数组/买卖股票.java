package 数组;

public class 买卖股票 {
    public static void main(String[] args) {
        int[] nums = {9,2,7,1,6};
        System.out.println(fun(nums));
    }

    private static int fun(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] < min) {
                min = nums[i];
            }else if(nums[i] - min > max) {
                max = nums[i] - min;
            }
        }
        return max;
    }
}
