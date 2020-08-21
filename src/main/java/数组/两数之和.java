package 数组;

import java.util.ArrayList;
import java.util.List;

/*
1594916810105
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10, 12};
        int k = 13;
        System.out.println(fun(nums, k));
    }

    public static List<Integer> fun(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        List<Integer> result = new ArrayList<>();
        while (left != right) {
            if (nums[left] + nums[right] == k) {
                result.add(left);
                result.add(right);
                break;
            } else if (nums[left] + nums[right] > k) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
