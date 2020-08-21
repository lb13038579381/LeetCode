package 数组;

import java.util.*;

public class 只出现一次的数字 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }

    public static int[] singleNumber(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        if (nums.length == 1) {
            return nums;
        }
        Map<Integer, Integer> result = new HashMap<>();
        for (int num : nums) {
            if (!result.containsKey(num)) {
                result.put(num, 1);
            } else {
                result.put(num, result.get(num) + 1);
            }
        }
        List<Integer> resultl = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (entry.getValue().equals(1)) {
                resultl.add(entry.getKey());
            }
        }
        int[] resultp = new int[2];
        for (int i = 0; i < 2; i++) {
            resultp[i] = resultl.get(i);
        }
        return resultp;
    }
}
