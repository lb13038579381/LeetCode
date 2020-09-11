package 笔试题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class vipkid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Object o = new NullPointerException();

        String s = sc.next();
        String[] temp = {"", "十", "百", "千", "万", "亿"};
        String[] temp2 = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        Map<String, Integer> numMap = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            numMap.put(temp2[i], i);
        }
        map2.put(temp[1], 1);
        map2.put(temp[2], 2);
        map2.put(temp[3], 3);
        map2.put(temp[4], 4);
        map2.put(temp[5], 4);
        help(s, s.length() - 1, temp, temp2, numMap, map2);
    }

    public static int help(String s, int index, String[] temp, String[] temp2, Map<String, Integer> numMap, Map<String, Integer> map2) {
        Stack<String> stack = new Stack<>();
        char[] cs = s.toCharArray();
        int i = index;
        for (; i >= 0; i--) {
//            101543298764302
//            1001543298764302
//              10015432098764302
//                100154320098764302
//                1001543298764302 *
//                  1001543298764302

            String c = cs[i] + "";
            if (map2.containsKey(c)) {
                int u = map2.get(c);
                int temp1 = i - 1 ;
                while (temp1 > 0 && !map2.containsKey(cs[temp1] + "")) {
                    --temp1;
                }
                if (temp1 > 0 && map2.get(cs[temp1] + "") < u) {
                    i = help(s, i - 1, temp, temp2, numMap, map2);
                }
                while (stack.size() < u) {
                    stack.push("0");
                }
            }
            if (numMap.containsKey(c)){
                int u = numMap.get(c);
                stack.push(u + "");
            }
        }
        while (stack.size() > 0) {
            System.out.print(stack.pop());
        }
        return i;
    }
}
