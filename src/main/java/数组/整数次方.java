package 数组;

public class 整数次方 {
    public static void main(String[] args) {
        double a = 2;
        int k = Integer.MIN_VALUE;
        System.out.println(fun(a, k));
    }

    private static double fun(double a, int k) {
        if (k == 0)
            return 1;
        if (a == 0)
            return 0;
        if (a == 1)
            return 1;
        long k1 = k;
        if (k1 < 0) {
            k1 = -k1;
            a = 1 / a;
        }
        if (k1 % 2 == 0) {
            double temp = fun(a, Integer.valueOf(String.valueOf(k1 / 2)));
            return temp * temp;
        } else {
            double temp = fun(a, Integer.valueOf(String.valueOf(k1 / 2)));
            return temp * temp * a;
        }
    }
}
