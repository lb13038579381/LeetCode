package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8, 7, 6, 5, 45, 4, 3};
        int k = 15;
        System.out.println(fun(nums, k));
    }

    private static List<List<Integer>> fun(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            List<Integer> temp = new ArrayList<>();
            while (l < r) {
                if (nums[l] + nums[r] == k - nums[i]) {
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(new ArrayList<>(temp));
                    break;
                } else if (nums[l] + nums[r] < k - nums[i]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
