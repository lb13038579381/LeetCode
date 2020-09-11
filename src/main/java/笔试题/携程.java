package 笔试题;

import java.util.*;

public class 携程 {
    public static void main(String[] args) {
//        you
//        i love you,oyu loyo ue
//        jack
        Scanner sc = new Scanner(System.in);
        String from = sc.nextLine();
        String s = sc.nextLine();
        String to = sc.nextLine();
//        List<String> res = new ArrayList<>();
//        List<Character> cs = new ArrayList<>();
//        for (char c : from.toCharArray()) {
//            cs.add(c);
//        }
//        helper(0, cs, res);
//        for (String re : res) {
//            s = s.replace(re,to);
//        }
//        System.out.println(s);
        String[] ss = s.split(" ");
        List<String> allWords = new ArrayList<>();
        int p = 0;
        while (p < s.length()) {
            if (s.charAt(p) == ' ') {
                p++;
                continue;
            }
            if (!Character.isDigit(s.charAt(p)) && s.charAt(p) != ' ' && !Character.isLetter(s.charAt(p))) {
                allWords.add(String.valueOf(s.charAt(p)));
                p++;
            }
            StringBuilder sb = new StringBuilder();
            while (p < s.length() && Character.isLetter(s.charAt(p))) {
                sb.append(s.charAt(p));
                p++;
            }
            allWords.add(sb.toString());
        }
        char[] ct = from.toCharArray();
        Arrays.sort(ct);
        String newF = String.valueOf(ct);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < allWords.size(); i++) {
            String cur = allWords.get(i);
            char[] temp = cur.toCharArray();
            Arrays.sort(temp);
            if (newF.equals(String.valueOf(temp))) {
                ans.add(to);
            } else {
                ans.add(cur);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            result.append(ans.get(i));
            if (i + 1 < ans.size() && ans.get(i + 1).equals(",")) {
                result.append(",");
                i++;
            } else {
                if (i != ans.size() - 1) {
                    result.append(" ");
                }
            }
        }
        System.out.println(result);

//        fun("");
    }

    private static void helper(int first, List<Character> cs, List<String> res) {
        if (first == cs.size() - 1) {
            StringBuilder sb = new StringBuilder();
            for (Character c : cs) {
                sb.append(c);
            }
            res.add(sb.toString());
        }
        for (int i = first; i < cs.size(); i++) {
            Collections.swap(cs, first, i);
            helper(first + 1, cs, res);
            Collections.swap(cs, first, i);
        }
    }

    public static void fun(String s) {
        s = "a bc d eag f";
        String[] ss = s.split(" ");
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(ss));
        List<StringBuilder> res = new ArrayList<>();
        help(0, new ArrayList<>(), res, list);
        Set<Character> set = new HashSet<>();
        for (StringBuilder re : res) {
            System.out.println(re);
        }
        System.out.println();
        for (int i = 0; i < res.size(); i++) {
            for (char c : res.get(i).toString().toCharArray()) {
                if (set.contains(c)) {
                    StringBuilder t = res.get(i);
                    t.append("--circular dependency");
                    break;
                } else {
                    set.add(c);
                }
            }
            set.clear();
        }
        List<String> r = new ArrayList<>();
        for (StringBuilder re : res) {
            r.add(re.toString());
        }
        for (String re : r) {
            System.out.println(re);
        }
        System.out.println(res);
    }

    private static void help(int first, ArrayList<Character> cur, List<StringBuilder> res, List<String> all) {
        if (cur.size() == all.size()) {
            StringBuilder sb = new StringBuilder();
            cur.forEach(sb::append);
            res.add(sb);
            return;
        }
        for (int i = first; i < all.size(); i++) {
            String now = all.get(i);
            for (char c : all.get(i).toCharArray()) {
                cur.add(c);
                help(i + 1, cur, res, all);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
