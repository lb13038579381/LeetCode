package 笔试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class meituan {
    public static void main(String[] args) {
//        String s = "MMATSATMMT";
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < m; i++) {
//            sb.append(sc.next());
//        }
//        System.out.println(fun(sb.toString()));
        System.out.println(Math.random());

        int[][] nums = {{1, 5, 3, 4, 2},
                {2, 3, 5, 4, 1},
                {5, 4, 1, 2, 3},
                {1, 2, 5, 4, 3},
                {1, 4, 5, 2, 3}};
        String s = "";
        String[] sts = s.split(" ");
        List<Integer> res = fun1(nums);
        for (int i = 0; i < res.size() - 1; i++) {
            System.out.print(res.get(i) + " ");
        }
        System.out.print(res.get(res.size() - 1));
        int n1 = (int) System.currentTimeMillis();
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(r.nextInt(6));
        }
        System.out.println(fun1(nums));
    }

    private static List<Integer> fun1(int[][] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!res.contains(nums[i][j])) {
                    res.add(nums[i][j]);
                    break;
                }
            }
        }
        return res;
    }

    private static String fun(String s) {
        int l = 0;
        int resl = 0;
        int resr = 0;
        while (l < s.length()) {
            if (s.charAt(l) == 'T') {
                resl = l;
                break;
            }
            l++;
        }
        int r = s.length() - 1;
        while (r > resl) {
            if (s.charAt(r) == 'M') {
                resr = r;
                break;
            }
            r--;
        }
        return s.substring(resl + 1, resr);
    }
}
