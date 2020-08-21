package 数组;

import java.util.Arrays;
import java.util.Stack;

public class 快排 {
    public static void main(String[] args) {
        int[] nums = {6, 4, 7, 9, 3, 2, 8, 1, 10};
        System.out.println(Arrays.toString(递归(nums)));
        System.out.println(Arrays.toString(非递归(nums)));

    }

    private static int[] 非递归(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(nums.length-1);
        while(!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            int flag = helper1(nums,start,end);

            if(flag > start) {
                stack.push(start);
                stack.push(flag-1);
            }
            if(flag < end && flag >= 0) {
                stack.push(flag +1);
                stack.push(end);
            }
        }
        return nums;
    }

    private static int helper1(int[] nums, int start, int end) {
        if(start >= end) {
            return-1;
        }
        int left = start;
        int right = end;
        int temp = nums[left];
        while(left < right) {
            while(left < right && nums[right] >= temp) {
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }

    private static int[] 递归(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        helper(nums, start, end);
        return nums;
    }

    private static void helper(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int left = start;
        int right = end;
        int midValue = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= midValue) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= midValue) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = midValue;
        helper(nums, start, left - 1);
        helper(nums, left + 1, end);
    }
}
