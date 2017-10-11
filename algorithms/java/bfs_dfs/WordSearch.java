package bfs_dfs;

/**
 * Created by Yang on 2017/10/8.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, new boolean[board.length][board[0].length], word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int x, int y, boolean[][] used, String word, int position) {
        if (position == word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        if (used[x][y] || board[x][y] != word.charAt(position)) {
            return false;
        }
        used[x][y] = true;
        boolean res = exist(board, x-1, y, used, word, position+1)
                || exist(board, x+1, y, used, word, position+1)
                || exist(board, x, y-1, used, word, position+1)
                || exist(board, x, y+1, used, word, position+1);
        used[x][y] = false;
        return res;
    }
}
