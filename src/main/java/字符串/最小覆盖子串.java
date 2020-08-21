package 字符串;

import java.util.ArrayList;
import java.util.List;

public class 最小覆盖子串 {
    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        System.out.println(fun(str, "ABC"));
    }

    private static String fun(String str, String target) {
        if (str == null || str == "" || target == null || target == "" || str.length() < target.length()) {
            return "";
        }
        int[] need = new int[128];
        int[] curWindow = new int[128];
        for (char c : target.toCharArray()) {
            need[c]++;
        }
        int left = 0;
        int right = 0;

        int resLeft = -1;
        int resRight = -1;
        int count = 0;
        while (right < str.length()) {
            char ch = str.charAt(right);
            curWindow[ch]++;
            if (need[ch] > 0 && need[ch] >= curWindow[ch]) {
                count++;
            }
            while (count == target.length()) {
                if ((resLeft == -1 && resRight == -1) || right - left < resRight - resLeft) {
                    resLeft = left;
                    resRight = right;
                }
                ch = str.charAt(left);
                if (need[ch] > 0 && need[ch] >= curWindow[ch]) {
                    count--;
                }
                curWindow[ch]--;
                left++;
            }
            right++;
        }
        if (resLeft != -1 && resRight != -1) {
            return str.substring(resLeft, resRight + 1);
        }
        return "";

    }
}
