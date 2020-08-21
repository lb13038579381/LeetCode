package 其他;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最小k个数 {
    public static void main(String[] args) {
        int[] nums = {324, 234, 23, 4, 234, 23, 45, 435, 4, 35, 34, 5, 23, 42, 34, 23, 4, 234, 23, 42, 41, 2, 3};
        System.out.println(fun(nums, 2));
    }

    private static List<Integer> fun(int[] nums, int k) {
        for (int i = nums.length / 2; i >= 0; i--) {
            buildHeap(nums, i, nums.length);
        }
        System.out.println(Arrays.toString(nums));

        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            buildHeap(nums, 0, i - 1);

        }
        System.out.println(Arrays.toString(nums));
        if (k > nums.length) {
            return new ArrayList<>();
        }
        for (int i = k / 2; i >= 0; i--) {
            buildHeap(nums, i, k);
        }
        System.out.println(Arrays.toString(nums));

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[0] > nums[i]) {
                swap(nums, 0, i);
                buildHeap(nums, 0, k);
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, k)));
        return new ArrayList<>();
    }

    private static void buildHeap(int[] nums, int cur, int length) {
        int left = 2 * cur + 1;
        int right = 2 * cur + 2;
        int temp = cur;
        if (left < length && nums[left] > nums[temp]) {
            temp = left;
        }
        if (right < length && nums[right] > nums[temp]) {
            temp = right;
        }
        if (temp != cur) {
            int t = nums[temp];
            nums[temp] = nums[cur];
            nums[cur] = t;
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
