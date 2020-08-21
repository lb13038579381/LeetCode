package 字符串;

public class 子序列 {
    public static void main(String[] args) {
        String str = "abchdsjsfhs";
        String from = "aaaaaa";
        System.out.println(fun(str, from));
    }

    private static boolean fun(String str, String from) {
        char[] char1 = str.toCharArray();
        char[] char2 = from.toCharArray();
        int p1 = 0;
        int p2 = 0;
        while (p1 < char1.length && p2 < char2.length) {
            if (char1[p1] == char2[p2]) {
                p2++;
                p1++;
                if(p2 == char2.length) {
                    return true;
                }
            } else {
                p1++;
            }
        }
        return false;
    }
}
