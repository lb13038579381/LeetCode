package 数组;

/*
1594920743844
 */
public class 斐波那契 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fun(n));
    }

    private static int fun(int n) {
        if(n == 1 || n ==2) {
            return 1;
        }
        int f1 = 1;
        int f2 = 1;
        int result = f1+f2;
        for(int i = 3;i < n;i++) {
            f1= f2;
            f2= result;
            result = f1+f2;

        }
        return result;
    }
}
