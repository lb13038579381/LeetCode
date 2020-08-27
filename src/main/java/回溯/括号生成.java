package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(fun(3));
    }

    private static List<String> fun(int n) {
        if(n == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();

        if(n == 1) {
            res.add("()");
            return  res;
        }
        List<Character> cur = new ArrayList<>();
        dfs(res, cur, 0, 0, n);
        return res;
    }

    private static void dfs(List<String> res, List<Character> cur, int left, int right, int n) {
        if (cur.size() == n * 2) {
            StringBuffer sb = new StringBuffer();
            cur.forEach(o -> sb.append(o));
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            cur.add('(');
            dfs(res, cur, left + 1, right, n);
            cur.remove(cur.size() - 1);
        }
        if (right < left) {
            cur.add(')');
            dfs(res, cur, left, right + 1, n);
            cur.remove(cur.size() - 1);
        }
    }
}
