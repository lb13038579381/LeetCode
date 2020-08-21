package 笔试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 贝壳笔试 {
    public static void main(String[] args) {
//        String str = "acac";
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        StringBuilder s = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            s.append(sc.next());
//        }
//        str = s.toString();
//        System.out.println(huiwen(str));
//
        System.out.println(ranse(10, 10));
//        int t = sc.nextInt();
//        for(int i = 0;i < t;i++){
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            ranse(n,m);
//        }[
//        System.out.println(ziqujian(new int[]{1}));
        int a = Integer.MAX_VALUE + Integer.MIN_VALUE;
        System.out.println(a);
    }

    /*
    替换字符串最少变成回文串
     */
    private static int huiwen(String str) {
        int mid = str.length() / 2;
        int left = 0;
        int right = str.length() - 1;
        int res = 0;
        if (str.length() % 2 == 1) {
            while (left < mid && right > mid) {
                if (str.charAt(left) == str.charAt(right)) {
                    left++;
                    right--;
                } else {
                    left++;
                    right--;
                    res++;
                }
            }
        } else {
            while (left < mid && right >= mid) {
                if (str.charAt(left) == str.charAt(right)) {
                    left++;
                    right--;
                } else {
                    left++;
                    right--;
                    res++;
                }
            }
        }
        System.out.println();
        return res;
    }

    //    对矩阵染色，每种颜色数量相同，所有格子必须染色，相邻格子不同颜色
    //n行数 m列数
    //n * m矩阵染色
    private static int ranse(int n, int m) {
        int[] yanse = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                List<Integer> curYanse = new ArrayList<>();
                //左边
                if (j - 1 >= 0 && temp[i][j - 1] != 0) {
                    curYanse.add(temp[i][j - 1]);
                }
                //右边
                if (j + 1 < m && temp[i][j + 1] != 0) {
                    curYanse.add(temp[i][j + 1]);
                }
                //上边
                if (i - 1 >= 0 && temp[i - 1][j] != 0) {
                    curYanse.add(temp[i - 1][j]);
                }
                //下边
                if (i + 1 < n && temp[i + 1][j] != 0) {
                    curYanse.add(temp[i + 1][j]);
                }
                if (curYanse.isEmpty()) {
                    temp[i][j] = 1;
                } else {
                    for (int p = 0; p < yanse.length; p++) {
                        if (!curYanse.contains(yanse[p])) {
                            temp[i][j] = yanse[p];
                            break;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, temp[i][j]);
            }
        }
        for (int[] ints : temp) {
            System.out.println(Arrays.toString(ints));
        }
        return res;
    }

    //给出一个正整数序列，求一个子区间使得这个区间内的数或起来大
    private static int ziqujian(int[] nums) {
        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int left = 0;
        int right = 1;
        int res = Integer.MIN_VALUE;
        int resL = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (i + 1 < nums.length) {
                        int temp = nums[i];
                        for (int p = i + 1; p < j; p++) {
                            temp = temp | nums[p];
                        }
                        if (temp > res) {
                            resL = Math.min(j - i, resL);
                        }
                }
            }
        }
        return resL;
    }
}
