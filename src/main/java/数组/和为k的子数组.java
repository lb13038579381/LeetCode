package 数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 和为k的子数组 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 3, 2, 1, 3, 3};
        int t = 6;
        System.out.println(fun2(nums, t));
    }

    private static List<List<Integer>> fun(int[] nums, int t) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                if (preSum[i] + t == preSum[j]) {
                    List<Integer> temp = new ArrayList<>();
                    for (int p = i; p < j; p++) {
                        temp.add(nums[p]);
                    }
                    res.add(temp);
                }
            }
        }
        return res;
    }

    private static int fun2(int[] nums, int t) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int curSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (map.containsKey(curSum - t)) {
                count += map.get(curSum - t);
            }
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        return count;
    }
}
