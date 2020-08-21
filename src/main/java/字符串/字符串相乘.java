package 字符串;

public class 字符串相乘 {
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "456";
        System.out.println(fun(s1, s2));
        System.out.println(fun1(s1, s2));
    }

    private static String fun(String s1, String s2) {
        int n = 0;
        String res = "0";
        for (int i = s2.length() - 1; i >= 0; i--) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < n; j++) {
                temp.append("0");
            }
            int jin = 0;
            for (int p = s1.length() - 1; p >= 0; p--) {
                int n1 = s1.charAt(p) - '0';
                int t = (n1 * (s2.charAt(i) - '0')) + jin;
                int cur = t % 10;
                temp.append(cur);
                jin = t / 10;
            }
            if (jin != 0) {
                temp.append(jin);
            }
            n++;
            res = addStrings(res, temp.reverse().toString());
        }
        return res;
    }

    /**
     * 对两个字符串数字进行相加，返回字符串形式的和
     */
    public static String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }


    private static String fun1(String s1, String s2) {
        int n = 0;
        String res = "0";
        for (int i = s1.length() - 1; i >= 0; i--) {
            int jin = 0;
            StringBuilder temp = new StringBuilder();
            for (int p = 0; p < n; p++) {
                temp.append("0");
            }
            for (int j = s2.length() - 1; j >= 0; j--) {
                int n1 = s1.charAt(i) - '0';
                int n2 = s2.charAt(j) - '0';
                temp.append((n1 * n2 + jin) % 10);
                jin = (n1 * n2 + jin) / 10;
            }
            if (jin != 0) {
                temp.append(jin);
            }
            n++;
            res = addStr(res, temp.reverse().toString());
        }
        return res;
    }

    private static String addStr(String str, String str1) {
        int jin = 0;
        int r1 = str.length() - 1;
        int r2 = str1.length() - 1;
        StringBuilder res = new StringBuilder();
        while (r1 >= 0 || r2 >= 0) {
            int temp = 0;
            if (r1 >= 0) {
                temp += str.charAt(r1) - '0';
                r1--;
            }
            if (r2 >= 0) {
                temp += str1.charAt(r2) - '0';
                r2--;
            }
            if (jin != 0) {
                temp += jin;
            }
            res.append(temp % 10);
            jin = temp / 10;
        }
        if (jin != 0) {
            res.append(jin);
        }
        return res.reverse().toString();

    }
}
