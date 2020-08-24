package 字符串;

public class lc459重复子字符串 {
    public static void main(String[] args) {
        String s = "ab";
        System.out.println(fun(s));
    }

    private static boolean fun(String s) {
        int n = s.length();
        for (int i = 0; 2 * i <= n; i++) {
            if (i == n - 1) {
                return false;
            }
            if (n % (i + 1) == 0) {
                boolean res = true;
                int p = 0;
                for (int j = i + 1; j < n; j++) {
                    if (p == i + 1) {
                        p = 0;
                    }
                    if (s.charAt(p) != s.charAt(j)) {
                        res = false;
                        break;
                    }
                    p++;

                }
                if (res) {
                    return res;
                }
            }

        }
        return false;
    }
}
