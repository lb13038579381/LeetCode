package 笔试题;

import 字符串.LC79单词搜索;

import java.util.*;

public class xiaomi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ns = s.split(" ");
        List<Integer> res = new ArrayList<>();
        for (String temp : ns) {
            if (temp.length() < 8 || temp.length() > 120) {
                res.add(1);
            } else {
                boolean hasnum = false;
                boolean haslow = false;
                boolean hasupp = false;
                boolean haselse = false;
                for (char c : temp.toCharArray()) {
                    if (Character.isDigit(c)) {
                        hasnum = true;
                    } else if (Character.isUpperCase(c)) {
                        hasupp = true;
                    } else if (Character.isLowerCase(c)) {
                        haslow = true;
                    } else {
                        haselse = true;
                    }
                }
                if (hasnum && haslow && hasupp && haselse) {
                    res.add(0);
                } else {
                    res.add(2);
                }
            }
        }
        for (Integer re : res) {
            System.out.println(re);
        }
    }
}
