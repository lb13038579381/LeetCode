package 数组;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        for (int i = 0; i < 2; i++) {
            buildHeap(nums, i, 2);
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < nums[0]) {
                int t = nums[i];
                nums[i] = nums[0];
                nums[0] = t;
                buildHeap(nums,0,2);
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sort(nums)));
    }

    private static int[] sort(int[] nums) {
        //首先建堆
        for (int i = nums.length / 2; i >= 0; i--) {
            buildHeap(nums, i, nums.length - 1);
        }
        for (int i = nums.length - 1; i >= 1; i--) {
            int t = nums[0];
            nums[0] = nums[i];
            nums[i] = t;
            buildHeap(nums, 0, i - 1);
        }
        return nums;
    }

    private static void buildHeap(int[] nums, int cur, int length) {
        int left = 2 * cur + 1;
        int right = 2 * cur + 2;
        int temp = cur;
        if (left <= length && nums[left] > nums[temp]) {
            temp = left;
        }
        if (right <= length && nums[right] > nums[temp]) {
            temp = right;
        }
        if (temp != cur) {
            int t = nums[temp];
            nums[temp] = nums[cur];
            nums[cur] = t;
            buildHeap(nums, temp, length);
        }
    }
}
