package 其他;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 最长连续序列 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(fun(nums));
        System.out.println(isStraight(new int[]{0,0,1,2,5}));
    }
    public static boolean isStraight(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int count0 = 0;
        for (int a : nums) {
            if (a == 0) {
                count0++;
                continue;
            }
            max = Math.max(max, a);
            min = Math.min(min, a);

        }
        if ((max - min - 1 - (nums.length - count0 - 2)) <= count0) {
            return true;
        }
        return false;
    }
    private static int fun(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int maxLength = 0;
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLength = 1;
                List<Integer> t = new ArrayList<>();
                t.add(curNum);
                while (set.contains(curNum + 1)) {
                    curLength++;
                    curNum = curNum + 1;
                    t.add(curNum);
                }
                if (curLength > maxLength) {
                    maxLength = Math.max(maxLength, curLength);
                    res = new ArrayList<>(t);
                }
            }
        }
        System.out.println(res);
        return maxLength;
    }
}
