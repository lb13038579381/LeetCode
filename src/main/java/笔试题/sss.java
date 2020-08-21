package 笔试题;

import java.util.*;

public class sss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < m; i++) {
            num[i] = sc.nextInt();
        }
        List<Integer> temp = new ArrayList<>();
        for (int t : num) {
            temp.add(t);
        }
        Map<Integer, List<Integer>> t = new HashMap<>();
        for (int i = 0; i < n; i++) {
            t.put(i, new ArrayList<>());
        }
        int addCount = 0;
        for (int i = 0; i < n; i++) {
            if (num[i] == 0) {
                break;
            }
            for (int j = 1; j < num[i]; j++) {
                if (!temp.contains(j) && num[i] > j) {
                    List<Integer> te = t.getOrDefault(i, new ArrayList<>());
                    te.add(j);
                    t.put(i, te);
                    temp.add(j);
                    addCount++;
                    if (addCount == n - m) {
                        break;
                    }
                }
            }
            if (addCount == n - m) {
                break;
            }
        }
        List<Integer> end = new ArrayList<>();
        if (addCount != n - m) {
            int i = 0;
            while (addCount != n - m) {
                if (!temp.contains(i)) {
                    end.add(i);
                    addCount++;
                }
                i++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < t.size(); i++) {
            result.addAll(t.get(i));
            if (i < m) {
                result.add(num[i]);
            }
        }
        result.addAll(end);
        System.out.println(result);

    }
}
