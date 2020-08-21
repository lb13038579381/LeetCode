package 数组;

public class 盛水最多的容器 {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(fun(nums));
    }

    private static int fun(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int left = 0;
        int right = nums.length - 1;
        int cur;
        while (left < right) {
            cur = (right - left) * Math.min(nums[left], nums[right]);
            res = Math.max(cur,res);
            if(nums[left] > nums[right]) {
                right--;
            }else {
                left++;
            }
        }
        return res;
    }
}
