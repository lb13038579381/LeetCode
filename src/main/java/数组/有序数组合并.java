package 数组;

import java.util.Arrays;

public class 有序数组合并 {
    public static void main(String[] args) {
        int[] nums1 = {3, 5, 7, 0, 0, 0, 0};
        int[] nums2 = {2, 4, 6, 8};
        System.out.println(Arrays.toString(fun(nums1, nums2, 3, 4)));
    }

    private static int[] fun(int[] nums1, int[] nums2, int a, int b) {
        int p1 = a - 1;
        int p2 = b - 1;
        int p = a + b - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p--;
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
                p--;
            }
        }
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println();
        return nums1;
    }
}
