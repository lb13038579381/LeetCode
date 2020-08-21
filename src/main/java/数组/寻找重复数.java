package 数组;

/*
1594920782834
 */
public class 寻找重复数 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] xx  = {0,1,0};
        System.out.println(fun(xx));
    }

    private static int fun(int[] nums) {
        for(int i = 0;i < nums.length;i++) {
            int temp = Math.abs(nums[i]);
            if(nums[temp] >0) {
                nums[temp] = - nums[temp];
            }else {
                return Math.abs(nums[i]);
            }
        }
        return -1;
    }
}
