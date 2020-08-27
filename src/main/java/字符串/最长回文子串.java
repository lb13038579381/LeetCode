package 字符串;

public class 最长回文子串 {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(s.substring(1,2));
        System.out.println(fun(s));
    }

    private static String fun(String s) {
        int n = s.length();
        if (n == 1 || n == 0) {
            return s;
        }
        if (n == 2) {
            return s.charAt(0) == s.charAt(1) ? s : "";
        }
        int max = Integer.MIN_VALUE;
        int start = -1;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0;i<n;i++) {
            dp[i][i] = true;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (i + 1 == j) {
                        dp[i][j] = true;
                        start=i;
                        max = j-i+1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                        if(dp[i][j]) {
                            if (j - i + 1 > max) {
                                max = j - i + 1;
                                start = i;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(start + " " + max);

        return start == -1 ? s.substring(0, 1) : s.substring(start, max + start);
    }

}
