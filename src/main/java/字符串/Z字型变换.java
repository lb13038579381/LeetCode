package 字符串;

import java.util.ArrayList;
import java.util.List;

public class Z字型变换 {
    public static void main(String[] args) {
        String str = "asdaksjdsfhdjsfsfjsdkfjsdk";
        System.out.println(fun(str, 4));
    }

    private static String fun(String str, int k) {
        if (str.length() == 0) {
            return str;
        }
        if (k > str.length()) {
            return str;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (char c : str.toCharArray()) {
            list.get(i).append(c);
            if (i == 0 || i == list.size() - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            System.out.println(stringBuilder.toString());
            res.append(stringBuilder);
        }
        return res.toString();
    }
}
