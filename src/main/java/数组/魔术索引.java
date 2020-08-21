package 数组;

public class 魔术索引 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 6, 8, 9, 9, 10, 10};
        System.out.println(fun(nums));
    }

    private static int fun(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static int helper(int[] nums, int l, int r) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] == mid) {
            return mid;
        }
        int res = helper(nums, l, mid - 1);
        if (res != -1) {
            return res;
        } else if (nums[mid] == mid) {
            return mid;
        } else {
            return helper(nums, mid + 1, r);
        }

    }
}
