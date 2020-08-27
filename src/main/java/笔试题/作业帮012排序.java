package 笔试题;

import java.util.Arrays;

 class 作业帮012排序 {
    //2 0 1 0 2 1 0
    public static void main(String[] args) {
        int[] nums = {2, 0, 1, 0, 2, 1, 0, 2, 1, 2, 1, 2, 2, 0, 1, 2, 1};
        int[] nums1 = {2, 0, 1, 0, 2, 1, 0};
//                       0  0  0  1  1  2  2
        System.out.println(Arrays.toString(fun(nums)));
    }

    private static int[] fun(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (num == 0) {
                count0++;
            }
            if (num == 1) {
                count1++;
            }
            if (num == 2) {
                count2++;
            }
        }
        // {0, 0, 0, 0,   1, 1, 1, 2, 1, 2,   2, 2, 2, 2, 1, 2, 1};
//        int[] nums = {0, 0, 0, 0,   1, 1, 1, 2, 1, 2,   2, 2, 2, 2, 1, 2, 1};
        int start0 = 0;
        int start1 = count0;
        int start2 = count1 + count0;
        int i = 0;
        while (i < nums.length) {
            int target = -1;
            if (nums[i] == 0) {
                swap(nums, i, start0);
                target = start0;
                start0++;
            } else if (nums[i] == 1) {
                swap(nums, i, start1);
                target = start1;
                start1++;
            } else if (nums[i] == 2) {
                swap(nums, i, start2);
                target = start2;
                start2++;
            }
            if (i == target) {
                i++;
            }
            if (i == count0) {
                i = start1;
            } else if (i == count0 + count1) {
                i = start2;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
