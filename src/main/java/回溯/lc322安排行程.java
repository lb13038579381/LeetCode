package 回溯;

import java.util.*;

public class lc322安排行程 {
    public static void main(String[] args) {
        List<List<String>> all = new ArrayList<>();
        all.add(Arrays.asList("ATL","SFO"));

        all.add(Arrays.asList("ATL","JFK"));
        all.add(Arrays.asList("SFO", "ATL"));

        all.add(Arrays.asList("JFK", "ATL"));
        all.add(Arrays.asList("JFK", "SFO"));

        System.out.println(fun(all));
        System.out.println(xx);
    }
static boolean end = false;
    static List<List<String>> xx = new ArrayList<>();
    private static List<String> fun(List<List<String>> all) {
        List<String> res = new ArrayList<>();
        helper(0,res,all);
        return res;
    }

    private static void helper(int first, List<String> res, List<List<String>> all) {
        if(end) {
            return;
        }
        if(canSuccess(all)) {
            res.addAll(all.get(0));
            for (int i = 1;i<all.size();i++) {
                res.add(all.get(i).get(1));
            }
            xx.add(new ArrayList<>(res));
            res.clear();
            return;
        }
        for(int j = first;j<all.size();j++) {
            Collections.swap(all,j,first);
            helper(first+1,res,all);
            Collections.swap(all,j,first);
        }
    }

    private static boolean canSuccess(List<List<String>> cur) {
        for (int i = 0; i < cur.size()-1; i++) {
            if(!cur.get(i).get(1).equals(cur.get(i+1).get(0))) {
                return false;
            }
        }
        return true;
    }
}
