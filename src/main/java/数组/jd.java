package 数组;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class jd {
    public static void main(String[] args) {
        //f(n)=1/5-1/10+1/15-1/20+1/25-......+1/(5*(2*n-1))-1/(5*2*n)。
//            Scanner sc = new Scanner(System.in);
//            int n = sc.nextInt();
//            if (n == 1) {
//                System.out.println("0.1000");
//                return;
//            }
//            BigDecimal yi = new BigDecimal("1");
//            BigDecimal p = new BigDecimal("10");
//            BigDecimal res = new BigDecimal("0.2");
//            BigDecimal fuyi = new BigDecimal("-1");
//
//            for (int i = 1; i < n; i++) {
//                res = i % 2 == 0 ? res.add(yi.divide(p, 4, BigDecimal.ROUND_HALF_DOWN)) : res.add(yi.divide(p, 4, BigDecimal.ROUND_HALF_DOWN).multiply(fuyi));
//                p = p.add(new BigDecimal("5"));
//                System.out.println(p);
//            }
//            System.out.println(res);
//

//        Scanner sc = new Scanner(System.in);
//        int start = sc.nextInt();
//        int end = sc.nextInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10000; i++) {
            if (i >= 0 && i < 100) {
                if (isSuShu(i % 10) || isSuShu(i / 10 % 10)) {
                    res.add(i);
                    continue;
                }
            }
            char[] cs = String.valueOf(i).toCharArray();
            int l = 0;
            int r = cs.length - 1;
            int tIndex = -1;
            int count = 0;
            while (l < r) {
                if (cs[l] - '0' == cs[r] - '0') {
                    l++;
                    r--;
                } else if (cs[l] - '0' == cs[r - 1] - '0') {
                    tIndex = r;
                    r--;
                    count++;
                } else if (cs[l + 1] - '0' == cs[r] - '0') {
                    tIndex = l;
                    l++;
                    count++;
                } else {
                    break;
                }
                if (count == 2) {
                    continue;
                }
            }
            if (l == r && count == 0) {
                boolean is1 = false;
                for (char c1 : cs) {
                    if (cs[0] - '0' != c1 - '0') {
                        is1 = true;
                        break;
                    }
                }
                if (!is1) {
                    count = 1;
                    tIndex = 0;
                } else {
                    continue;
                }
            }
            if (count == 1) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < cs.length; j++) {
                    if (j != tIndex) {
                        sb.append(cs[j]);
                    }
                }
                int temp;
                try {
                    temp = Integer.valueOf(sb.toString());
                } catch (Exception e) {
                    continue;
                }
                if (isSuShu(temp)) {
                    res.add(i);
                }
            }
        }
        System.out.println(res);
        System.out.println(primePalindrome(10000));
    }

    private static boolean isSuShu(int a) {
        if (a == 0)
            return false;
        for (int i = a / 2; i > 0; i--) {
            for (int j = 2; j < i; j++) {
                if (i * j == a) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int primePalindrome(int N) {
        int res = 0;
        List<Integer> s = new ArrayList<>();
        for (int p = 0; p < N; p++) {
            N = p;
            boolean isPrime = true, isPalindrome = true;
            // 判断是否为素数
            for (int i = 2, len = (int) Math.sqrt(N); i <= len; ++i) {
                if (N % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            // 判断是否为回文数
            String cs = String.valueOf(N);
            for (int j = 0, len = cs.length() >> 1; j < len; ++j) {
                if (cs.charAt(j) != cs.charAt(cs.length() - j - 1)) {
                    isPalindrome = false;
                    break;
                }
            }
            // 是回文数和素数
            if (isPrime && isPalindrome) {
                res++;
                s.add(N);
            }
            N = 10000;
        }
        System.out.println(s);
        return res;
    }
}
