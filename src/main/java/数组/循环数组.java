package 数组;

import java.lang.annotation.Target;

public class 循环数组 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 9;
        System.out.println(fun(nums, 0));
    }

    private static int fun(int[] nums, int t) {
        if(nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == t) {
                return mid;
            }
            if (nums[mid] < nums[left]) {
                if (t >= nums[mid] && t<= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (t >= nums[left] && t <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
