package 其他;

import com.google.common.base.Strings;

public class 出现一半的数字 {
    public static void main(String[] args) {
        int[] nums = {1, 23, 12, 31, 23, 12, 3, 12, 4, 4, 32, 423, 4, 324, 32, 423, 4, 4, 4, 4, 4, 234, 23, 42, 34, 32, 4, 4, 44,};
        System.out.println(fun(nums));
    }

    private static int fun(int[] nums) {
        int target = -1;
        String s ="sad";
        for (char c : s.toCharArray()) {
            
        }
        int count = 0;
        for (int num : nums) {
            if (target == -1) {
                target = num;
                count++;
                continue;
            }
            if (target == num) {
                count++;
                continue;
            }
            if (count == 0) {
                target = num;
                continue;
            }
            count--;
        }
        count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        if (count > nums.length / 2) {
            return target;
        }
        return -1;
    }
}
