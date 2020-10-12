//package 笔试题;
//
//import java.util.*;
//
//public class 滴滴 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        int n = Integer.parseInt(s.split(" ")[0]);
//        int k = Integer.parseInt(s.split(" ")[1]);
//        char[][] nums = new char[n][n];
//        for (int i = 0; i < n; i++) {
//            String te = sc.nextLine();
//            for (int j = 0; j < 3; j++) {
//                nums[i][j] = te.toCharArray()[j];
//            }
//        }
//        if (nums[0][0] == '1') {
//            System.out.println("No Solution");
//        }
//        int res = 0;
//        if (nums[0][0] == '#') {
//            res += k;
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i - 1 >= 0) {
//                    dfs(i - 1, j);
//                }
//                if (i + 1 < n) {
//                    dfs(i + 1, j);
//                }
//                if (j - 1 >= 0) {
//                    dfs(i, j - 1);
//                }
//                if (j + 1 < n) {
//                    dfs(i, j + 1);
//                }
//            }
//        }
//
//    }
//
//    private static int dfs(char[][] nums, int i, int j,int k) {
//        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length) {
//            return 0;
//        }
//        char temp = nums[i][j];
//        nums[i][j] = 'x';
//        if(i-1>=0) {
//            if(nums[i][j] == '1') {
//
//            }
//        }
//        int up = dfs(nums, i - 1, j,);
//    }
//
//    static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
//        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k]) {
//            return false;
//        }
//        if (k == word.length - 1)
//            return true;
//        char temp = board[i][j];
//        board[i][j] = '/';
//        boolean res = dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1) || dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i + 1, j, k + 1);
//        board[i][j] = temp;
//        return res;
//    }
//}
