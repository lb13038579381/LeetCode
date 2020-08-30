package 笔试题;

import com.sun.org.apache.xml.internal.resolver.helpers.BootstrapResolver;
import sun.applet.AppletClassLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 达达 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int caozuo = sc.nextInt();
//        int n = sc.nextInt();
//        List<int[]> nums = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            String s = sc.nextLine();
//            int[] nn = new int[2];
//            nn[0] = Integer.valueOf(s.split(",")[0]);
//            nn[1] = Integer.valueOf(s.split(",")[1]);
//            nums.add(nn);
//        }
//        String tt = sc.next();
//        int[] t = new int[2];
//        t[0] = Integer.valueOf(tt.split(",")[0]);
//        t[1] = Integer.valueOf(tt.split(",")[1]);
//        if (caozuo == 1) {
//            for (int[] temp : nums) {
//                if (temp[0] > t[0] && temp[1] < t[1]) {
//                    System.out.println(temp[0] + "," + temp[1]);
//                }
//            }
//        } else {
//            for (int[] temp : nums) {
//                if (temp[0] > t[0] && temp[0] < t[1]) {
//                    System.out.println(temp[0] + "," + temp[1]);
//                }
//            }
//        }
        fun();
    }

    private static void fun() {
//        4 1 6 2 5 3 7
//        14 1 21 2 15 3 26 4 16 5 22 6 17 7 25 8 18 9 23 10 19 11 27 12 20 13 24
//        4 1 3 2
//        2 1 3
        int[] a = {1,2,3};
        int[] b = {1,2,3};
        System.out.println(Arrays.equals(a,b));
        int[] nums = new int[7];
        int now = 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = now;
            now++;
        }
        for (int i = 0; i < nums.length; i += 4) {
            nums[i] = now;
            now++;
        }
        for (int i = 2; i < nums.length; i += 8) {
            nums[i] = now;
            now++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = now + 2;
                now--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
