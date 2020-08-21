package 数组;

import java.util.Arrays;
import java.util.HashMap;

public class 比当前数小的下一个数 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 7, 6, 2};
        int[] nums1 = {1, 3, 2};
        fun(nums1);
        System.out.println((Arrays.toString(nums1)));
    }

    private static void fun(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return;
        int j = nums.length - 1;
        int left = 0;
        boolean flag = true;
        while (j > 0) {
            if (nums[j - 1] < nums[j]) {
                left = j - 1;
                flag = false;
                break;
            }
            j--;
        }
        j = nums.length - 1;
        if (!flag) {
            while (j >= 0) {
                if (nums[left] < nums[j]) {
                    int temp = nums[left];
                    nums[left] = nums[j];
                    nums[j] = temp;
                    nizhi(nums,left+1,nums.length-1);
                    break;
                }
                j--;
            }
        }else {
            nizhi(nums,0,nums.length-1);
        }
    }

    private static void nizhi(int[] nums,int l,int r) {
        while(l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
