package 数组;

public class 矩阵路径存在 {
    public static void main(String[] args) {
        char[][] board = {{'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}};
        String word = "abcced";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1)
            return true;
        char temp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1) || dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i + 1, j, k + 1);
        board[i][j] = temp;
        return res;
    }
}
