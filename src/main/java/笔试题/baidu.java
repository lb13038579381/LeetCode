package 笔试题;

import org.apache.poi.util.Removal;

import java.util.*;

public class baidu {
    static int res;

    public static void main(String[] args) {
        //        int[] nums = {5, 5, 5, 5, 5, 5, 5, 5, 0, 5, 5};
//        int zeroCount = 0;
//        int fiveCount = 0;
//        for (int num : nums) {
//            if (num == 0) {
//                zeroCount++;
//            } else {
//                fiveCount++;
//            }
//        }
//        if (zeroCount == 0) {
//            System.out.println("-1");
//            return;
//        }
//        if (fiveCount < 9) {
//            System.out.println("0");
//            return;
//        }
//        String temp = "555555555";
//        StringBuffer res = new StringBuffer();
//        for(int i = 0;i<fiveCount/9;i++) {
//            res.append(temp);
//        }
//        for (int i = 0; i < zeroCount; i++) {
//            res.append(0);
//        }
//        System.out.println(res);
//        int n = 7;
//        int m = 3;
//        help(0, m, n, new ArrayList<Integer>());
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int countOfCow = sc.nextInt();
            int countOfTalnet = sc.nextInt();
            List<List<int[]>> allT = new ArrayList<>();
            for (int j = 0; j < countOfTalnet; j++) {
                List<int[]> ttt = new ArrayList<>();
                int p = sc.nextInt();
                for (int q = 0; q < p; q++) {
                    int[] num = new int[2];
                    for (int o = 0; o < 2; o++) {
                        num[o] = sc.nextInt();
                    }
                    ttt.add(num);
                }
                allT.add(ttt);
            }
            System.out.println();
            int[] res = helper(allT, countOfCow);
            System.out.println(res.length);
            for (int i1 = 0; i1 < res.length - 1; i1++) {
                System.out.print(res[i1] + " ");
            }
            System.out.print(res[res.length - 1]);
        }
    }

    /*      1 2  4 5  8 8
            1 4  6 8

     */
    private static int[] helper(List<List<int[]>> allT, int countOfCow) {
        Map<Integer, String> map = new HashMap<>();
        List<List<Integer>> s = new ArrayList<>();
        for (List<int[]> ints : allT) {
            List<Integer> cccc = new ArrayList<>();
            for (int[] anInt : ints) {
                int l = anInt[0];
                int r = anInt[1];
                for (int p = l; p <= r; p++) {
                    if (p <= countOfCow) {
                        cccc.add(p);
                    }
                }
                s.add(cccc);
            }
        }
        List<Integer> res = he(s);
        int[] rr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            rr[i] = res.get(i);
        }
        Arrays.sort(rr);
        return rr;
    }

    private static List<Integer> he(List<List<Integer>> s) {
        if (s.size() == 1) {
            return s.get(0);
        }
        List<Integer> l1 = s.get(s.size() - 1);
        List<Integer> l2 = s.get(s.size() - 2);
        s.remove(s.size() - 1);
        s.remove(s.size() - 1);
        List<Integer> newl = new ArrayList<>();
        for (Integer integer : l1) {
            if(l2.contains(integer)) {
                newl.add(integer);
            }
        }
        s.add(newl);
        he(s);
        return s.get(0);
    }
}



