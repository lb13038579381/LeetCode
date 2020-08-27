package 数组;

import java.util.Arrays;

public class lc215数组中第K大 {
    public static void main(String[] args) {
        int[] nums = {1, 23, 2, 321, 43, 4, 543, 5, 345, 3, 2, 34, 23, 4, 13, 12, 312, 312, 3, 7777};
        int k = 5;

        System.out.println(fun(nums, 7));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static int fun(int[] nums, int k) {
        int n = nums.length;
        if(k > n) {
            return -1;
        }
        for (int i = nums.length / 2 ; i >= 0; i--) {
            buildHeap(i, n - 1, nums);
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, 0, i);
            if (i == n - k) {
                return nums[i];
            }
            buildHeap(0, i - 1, nums);
        }
        return -1;
    }

    private static void buildHeap(int start, int end, int[] nums) {
        int left = 2 * start + 1;
        int right = 2 * start + 2;
        int temp = start;
        if (left <= end && nums[left] > nums[temp]) {
            temp = left;
        }
        if (right <= end && nums[right] > nums[temp]) {
            temp = right;
        }
        if (temp != start) {
            swap(nums, temp, start);
            buildHeap(temp, end, nums);
        }

    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
