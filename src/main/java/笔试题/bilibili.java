package 笔试题;

import 动态规划.零钱兑换;

import java.util.*;

public class bilibili {
    public static void main(String[] args) {
        int[] nums  = {1,23,3,-2,32,13,-213,-12,3-5,-3,-2,2,-3,23};
        int start = 0;
        int p = nums.length-1;
        while(p >= 0) {
            if(nums[p] < 0) {
                swap(nums,p,start);
                start++;
            }else{
                p--;
            }
            if(p <=start) {
                break;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    //四个数加减乘除得到24
    private static boolean fun3(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(nums[0]);
        char[] c = {
                '+', '-', '*', '/'
        };
        List<String> all = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        all.add("7");
        all.add("2");
        all.add("1");
        all.add("10");

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < c.length; j++) {
                int size = all.size();
                for (int k = 0; k < size; k++) {
                    all.add(all.get(k) + c[j] + nums[i]);
                }
            }
        }
        Iterator it = all.iterator();
//        while (it.hasNext()) {
//            String t = it.next().toString();
//            if (t.length() != 8) {
//                it.remove();
//            }
//        }
        List<Integer> rr = new ArrayList<>();
        rr.add(1);
        rr.add(2);
        rr.add(7);
        rr.add(10);
        System.out.println(fun(rr));
//        System.out.println(all);
        System.out.println(queue);
        return true;
    }

    public static boolean fun(List<Integer> list) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            list.remove(i);
            if (getResult(list, temp)) {
                return true;
            }
            list.add(i, temp);
        }
        return false;
    }

    public static boolean getResult(List<Integer> list, int temp) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                int n = list.get(i);
                list.remove(i);
                if (getResult(list, temp * n) || getResult(list, temp + n) || getResult(list, temp - n)) {
                    return true;
                } else if (temp % n == 0) {
                    if (getResult(list, temp / n)) {
                        return true;
                    }
                }
                list.add(i, n);
            }
            return false;
        } else {
            if (temp == 24) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static int fun2(int n) {
        n = 1024 - n;
        n = 824;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int[] amount = {1, 4, 16, 64};
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            for (int j = amount.length - 1; j >= 0; j--) {
                if (amount[j] == i) {
                    temp = 0;
                    break;
                }
                if (amount[j] < i) {
                    if (temp != 0) {
                        temp = Math.min(dp[i - amount[j]], temp);
                    } else {
                        temp = dp[i - amount[j]];
                    }
                }
            }
            dp[i] = temp + 1;
        }
        return dp[n];
    }

    public static void fun1() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '(') {
                stack.push(')');
            }
            if (str.charAt(i) == '[') {
                stack.push(']');
            }
            if (str.charAt(i) == '{') {
                stack.push('}');
            }
            if (str.charAt(i) == '}') {
                if (stack.peek() == '}')
                    stack.pop();
                else {
                    System.out.println("false");
                    return;
                }
            }
            if (str.charAt(i) == ')') {
                if (stack.peek() == ')')
                    stack.pop();
                else {
                    System.out.println("false");
                    return;
                }
            }
            if (str.charAt(i) == ']') {
                if (stack.peek() == ']')
                    stack.pop();
                else {
                    System.out.println("false");
                    return;
                }
            }
            i++;
        }
        System.out.println("true");
    }
}
