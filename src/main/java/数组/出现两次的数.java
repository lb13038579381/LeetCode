package 数组;

import java.util.ArrayList;
import java.util.List;

public class 出现两次的数 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 3, 5, 4, 8, 9, 1, 2};
        System.out.println(fun(nums));
    }

    private static List<Integer> fun(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int t = Math.abs(nums[i]);
            if (nums[t] < 0) {
                result.add(t);
            } else {
                nums[t] = -nums[t];
            }
        }

        return result;
    }
}
