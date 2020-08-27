package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc17电话号码组合 {
    public static void main(String[] args) {
        String s = "23";
        System.out.println(fun(s));
    }

    private static List<String> fun(String s) {
        if (s.length() == 0) {
            return new ArrayList<>();
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> res = new ArrayList<>();
        if (s.length() == 1) {
            String s1 = map.get(s.charAt(0) - '0');
            for (int i = 0; i < s1.length(); i++) {
                res.add(String.valueOf(s1.charAt(i)));
            }
            return res;
        }
        List<String> all = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            all.add(map.get(s.charAt(i) - '0'));
        }
        List<Character> cur = new ArrayList<>();
        dfs(0, cur, all, res, s);
        return res;
    }

    private static void dfs(int first, List<Character> cur, List<String> all, List<String> res, String s) {
        if (cur.size() == s.length()) {
            StringBuffer sb = new StringBuffer();
            cur.forEach(o -> sb.append(o));
            res.add(sb.toString());
            return;
        }
        for (int j = first; j < all.size(); j++) {
            String now = all.get(j);
            for (int p = 0; p < now.length(); p++) {
                cur.add(now.charAt(p));
                dfs(j+1,cur,all,res,s);
                cur.remove(cur.size()-1);
            }
        }
    }
}
