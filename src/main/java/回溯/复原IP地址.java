package 回溯;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class 复原IP地址 {
    public static void main(String[] args) {
        String ip = "010010";
//        System.out.println(fun(ip));
        System.out.println(sqrt1(10000));
    }
    public static BigDecimal sqrt1(int x1) {
        BigDecimal x = new BigDecimal(x1);
        BigDecimal low = new BigDecimal("0");
        BigDecimal high = x;
        while (low.subtract(high).compareTo(BigDecimal.ZERO) <= 0) {
            BigDecimal mid = (low.add(high)).divide(new BigDecimal("2"));//防止溢出
            if (mid.multiply(mid).compareTo(BigDecimal.ZERO) == 0)
                return  mid;
            else if (mid.multiply(mid).subtract(x).compareTo(BigDecimal.ZERO) == -1)
                low =  mid.add(new BigDecimal("1"));
            else
                high = mid.subtract(new BigDecimal("1"));
        }
        return high;
    }
    public static double sqrt(double m) {
        double i = 0;
        int k = 0;
        while ((i * i) <= m)
            i += 0.1;
        for (int j = 0; j < 10; j++) {
            i = (m / i + i) / 2;
        }
        return i;
    }
    private static List<String> fun(String ip) {
        if (ip.length() > 12) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < ip.length(); i++) {
            for (int j = i + 1; j < ip.length(); j++) {
                for (int p = j + 1; p < ip.length(); p++) {
                    String split1 = ip.substring(0, i);
                    String split2 = ip.substring(i, j);
                    String split3 = ip.substring(j, p);
                    String split4 = ip.substring(p, ip.length());
                    if (check(split1) && check(split2) && check(split3) && check(split4)) {
                        StringBuilder temp = new StringBuilder();
                        temp.append(split1).append(".").append(split2).append(".").append(split3).append(".").append(split4);
                        res.add(temp.toString());
                    }
                }
            }
        }
        return res;

    }

    private static boolean check(String split) {
        System.out.println(split);
        if (split.length() == 0)
            return false;
        if (split.length() > 3)
            return false;
        if(split.length() == 1)
            return true;
        if (split.charAt(0) == '0')
            return false;
        if (Integer.parseInt(split) >= 256)
            return false;
        return true;
    }
}
