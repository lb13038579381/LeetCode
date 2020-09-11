package 字符串;

import java.util.*;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        int i = 0;
        i = ++i;
        System.out.println(i++);
        System.out.println(++i);
//        String s = "abcabcbb";
//        System.out.println(fun(s));
//        Map<String,String> ss = new HashMap<>();
//        int[] nums = {1,2,3,4,5,6,7,8,9};
//        int left = 0;
//        int right = nums.length-1;
//        while(left < right) {
//            swap(nums,left,right);
//            left++;
//            right--;
//        }
//        System.out.println(Arrays.toString(nums));
    }
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static int fun(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> temp = new HashMap<>();
        while (start < chars.length) {
            if (temp.containsKey(chars[start])) {
                max = Math.max(max, temp.size());
                start = temp.get(chars[start]);
                temp.clear();
            } else {
                temp.put(chars[start], start);
            }
            start++;
        }
        return temp.size() == 0 ? max : Math.max(max, temp.size());
    }
}
