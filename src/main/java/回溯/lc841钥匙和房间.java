package 回溯;

import java.util.*;

public class lc841钥匙和房间 {
    public static void main(String[] args) {
        List<List<Integer>> all = new ArrayList<>();
        all.add(Arrays.asList(1));
        all.add(Arrays.asList(1, 3, 2));
        all.add(Arrays.asList(2));
        all.add(Arrays.asList(0));
        System.out.println(fun(all));

    }

    static int[] res;

    private static boolean fun(List<List<Integer>> all) {
        if(all.size() == 0 || all.size() == 1) {
            return true;
        }
        res = new int[all.size()];
        Deque<Integer> deque = new LinkedList<>();
        for (Integer integer : all.get(0)) {
            deque.offer(integer);
        }
        while (!deque.isEmpty()) {
            int temp = deque.poll();
            res[temp] = 1;
            for (Integer integer : all.get(temp)) {
                if (res[integer] != 1) {
                    deque.offer(integer);
                }
            }
        }
        System.out.println(Arrays.toString(res));

        for (int re : res) {
            if(re == 0) {
                return false;
            }
        }
        return true;
    }
}
