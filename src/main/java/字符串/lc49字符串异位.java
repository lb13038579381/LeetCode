package 字符串;

import java.util.*;

public class lc49字符串异位 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String sorted = String.valueOf(cs);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> listEntry : map.entrySet()) {
            res.add(listEntry.getValue());
        }
        return res;
    }
}
