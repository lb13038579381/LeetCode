package 字符串;

public class 字符串转整数 {
    public static void main(String[] args) {
        String str = "123213aa";
        System.out.println(fun(str));
    }

    private static int fun(String str) {
        int res = 0;
        int n = 0;
        int i = str.length() - 1;
        boolean hasfu = false;
        boolean first = false;
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) != ' ') {
                if (str.charAt(j) == '-' || (str.charAt(j) - '0' > 0 && str.charAt(j) - '0' <= 9)) {
                    first = true;
                    break;
                } else {
                    first = false;
                    break;
                }
            }
        }
        if (!first) {
            return 0;
        }
        while (i >= 0) {
            if (str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9) {
                res += Math.pow(10, n) * (str.charAt(i) - '0');
                n++;
            } else if (str.charAt(i) == '-') {
                if (hasfu) {
                    return -1;
                }
                hasfu = true;
            }
            i--;

        }
        return hasfu ? (-1) * res : res;
    }
}
