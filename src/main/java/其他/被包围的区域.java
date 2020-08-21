package 其他;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 被包围的区域 {
    public static void main(String[] args) {
        char[][] board = {{'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'}
                , {'O', 'X', 'O', 'X', 'O', 'X'}};
        for (char[] fun : fun(board)) {
            System.out.println(Arrays.toString(fun));
        }
        for (int[] ints : marked) {
            System.out.println(Arrays.toString(ints));
        }
    }

//    [["O","X","X","O","X"],
//    ["X","O","O","X","O"],
//    ["X","O","X","O","X"],
//    ["O","X","O","O","O"],
//    ["X","X","O","X","O"]]
    static int[][] marked;

    private static char[][] fun(char[][] board) {
        if(board.length ==0 || board[0].length==0 || board.length==1||board[0].length==1)
            return new char[0][0];
        int m = board[0].length;
        int n = board.length;
        marked = new int[n][m];

        for (int i = 0; i < m; i++) {
            fun1(0, i, board, m, n);
            fun1(n - 1, i, board, m, n);
        }
        for (int i = 0; i < n; i++) {
            fun1(i, m - 1, board, m, n);
            fun1(i, 0, board, m, n);

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && marked[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
        return board;
    }

    private static void fun1(int i, int j, char[][] board, int m, int n) {
        Deque<int[]> deque = new LinkedList<>();
        if (board[i][j] == 'O') {
            deque.offer(new int[]{i, j});
            marked[i][j] = 1;
            while (!deque.isEmpty()) {
                int[] temp = deque.poll();
                int i1 = temp[0];
                int j1 = temp[1];
                marked[i][j] = 1;
                //向下
                if (i1 + 1 < n && board[i1 + 1][j1] == 'O' && marked[i1 + 1][j1] == 0) {
                    marked[i1 + 1][j1] = 1;
                    deque.offer(new int[]{i1 + 1, j1});
                }
                //向右
                if (j1 + 1 < m && board[i1][j1 + 1] == 'O' && marked[i1][j1 + 1] == 0) {
                    marked[i1][j1 + 1] = 1;
                    deque.offer(new int[]{i1, j1 + 1});
                }
                //向左
                if (j1 - 1 >= 0 && board[i1][j1 - 1] == 'O' && marked[i1][j1 - 1] == 0) {
                    marked[i1][j1 - 1] = 1;
                    deque.offer(new int[]{i1, j1 - 1});
                }
                //向上
                if (i1 - 1 >= 0 && board[i1 - 1][j1] == 'O' && marked[i1 - 1][j1] == 0) {
                    marked[i1 - 1][j1] = 1;
                    deque.offer(new int[]{i1 - 1, j1});
                }
            }
        }
    }
}
