package 字符串;

import java.util.*;

public class 词频 {
    public static void main(String[] args) {
        String a = "i";
        String b = "lo";
        String[] s = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        System.out.println(fun(s, 4));
    }

    private static List<String> fun(String[] s, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String s1 : s) {
            count.put(s1, count.getOrDefault(s1, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> count.get(o1).equals(count.get(o2))?o2.compareTo(o1):count.get(o2)-count.get(o1));

        for (Map.Entry<String, Integer> stringIntegerEntry : count.entrySet()) {
            queue.offer(stringIntegerEntry.getKey());
            if(queue.size() > k) {
                queue.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while(!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
    }
}
