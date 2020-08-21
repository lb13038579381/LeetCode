package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    在长度为n的数组中，数值均<n，有的数字重复，有的没有出现，找到没有出现的数
    1594918327644
 */
public class 找到消失的数字 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 5, 6, 8, 8};
        System.out.println(fun(nums));
    }

    public static List<Integer> fun(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp;
            if (nums[i] < 0) {
                temp = -nums[i];
            } else {
                temp = nums[i];
            }
            if (nums[temp] > 0) {
                nums[temp] = -nums[temp];
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i);
            }
        }
        return result;
    }
}
