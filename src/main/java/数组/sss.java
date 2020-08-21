package 数组;

import javax.management.relation.Relation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
3 3 10
1 1
2 5
3 7
2 4
4 8
6 9
 */
public class sss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int target = sc.nextInt();
        if(target == 0) {
            System.out.println("0");
            return;
        }
        int[] reliang = new int[m + n];
        int[] meiwei = new int[m + n];
        for(int i = 0;i<m+n;i++) {
            reliang[i] = sc.nextInt();
            meiwei[i] = sc.nextInt();
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < reliang.length; i++) {
            if (meiwei[i] >= target && reliang[i] < res) {
                res = reliang[i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = n; j < reliang.length; j++) {
                if (meiwei[i] + meiwei[j] >= target && reliang[i] + reliang[j] < res) {
                    res = reliang[i] + reliang[j];
                }
            }
        }
        System.out.println(res);


//        Scanner sc = new Scanner(System.in);
//        int k = sc.nextInt();
//        int m = sc.nextInt();
//        List<Integer> counts = new ArrayList<>();
//        for (int i = 0; i < m; i++) {
//            counts.add(sc.nextInt());
//        }
//        int cur = 0;
//        for (Integer count : counts) {
//            cur += count;
//            if (cur == k) {
//                System.out.println("paradox");
//                return;
//            }
//        }
//        if (cur < k) {
//            System.out.println(k - cur + " 0");
//            return;
//        }
//        cur = 0;
//        int curOfEnd = k;
//        int countOfBack = 0;
//        for (Integer count : counts) {
//            if (curOfEnd < count) {
//                countOfBack++;
//                curOfEnd = count - curOfEnd;
//                cur = k - curOfEnd;
//            } else {
//                cur += count;
//                curOfEnd -= count;
//            }
//        }
//        System.out.println(curOfEnd + " " + countOfBack);
    }
}
