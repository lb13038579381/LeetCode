package 数组;

public class 缺失的第一个正数 {
    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(fun(nums));
    }

    private static int fun(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int p = 0;
        while (p < nums.length) {
            if (nums[p] > 0 && nums[p] <= nums.length && nums[nums[p] - 1] != nums[p]) {
                int t = nums[nums[p] - 1];
                nums[nums[p] - 1] = nums[p];
                nums[p] = t;
            } else {
                p++;
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}
