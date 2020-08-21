package 数组;

import java.util.*;

public class 两个数组交集 {
    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {2, 1};
        System.out.println(Arrays.toString(fun(a, b)));

    }
/*
1 2
2 1
 */
    private static int[] fun(int[] a, int[] b) {
        if(a.length == 0 || b.length == 0) {
            return new int[0];
        }
        int p1 = 0;
        int p2 = 0;
        Set<Integer> result = new HashSet<>();
        while (p1 < a.length) {
            if (a[p1] == b[p2]) {
                result.add(a[p1]);
                p1++;
                p2=0;
            } else if (p1 < a.length && p2 == b.length - 1) {
                p1++;
                p2 = 0;
            } else {
                p2++;
            }
        }
        int[] res = new int[result.size()];
        int x = 0;
        for (Integer integer : result) {
            res[x] = integer;
            x++;
        }
        return res;
    }
}
