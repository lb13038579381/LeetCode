package 贪心;

public class lc55跳跃游戏 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(fun(nums));
    }

    private static boolean fun(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(i + nums[i], max);
                if (max >= nums.length - 1) {
                    return true;
                }
            }else{
                return false;
            }
        }
        return false;
    }
}
