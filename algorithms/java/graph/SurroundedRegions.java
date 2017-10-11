package graph;

/**
 * Created by Yang on 2017/10/9.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3) {
            return;
        }
        // Step 1. 检查所有的边界'O'，将其相邻的所有'O'标记为'M'（或者你喜欢的任何一个符号）
        for (int r = 0; r < board.length; r++) { //左右两个边界
            if (board[r][0] == 'O') {
                board[r][0] = 'M';
                mark(board, r, 1); //左边界
            }
            if (board[r][board[0].length - 1] == 'O') {
                board[r][board[0].length - 1] = 'M';
                mark(board, r, board[0].length - 2); //右边界
            }
        }
        for (int c = 1; c < board[0].length - 1; c++) {
            if (board[0][c] == 'O') { //上边界
                board[0][c] = 'M';
                mark(board, 1, c);
            }
            if (board[board.length - 1][c] == 'O') { //下边界
                board[board.length - 1][c] = 'M';
                mark(board, board.length - 2, c);
            }
        }
        // Step 2. 将所有的'M'变成'O'，其他的变成'X'
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'M') {
                    board[r][c] = 'O';
                } else {
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void mark(char[][] board, int r, int c) {
        if (board[r][c] == 'O') {
            board[r][c] = 'M';
            if (r > 1 && board[r - 1][c] == 'O') {
                mark(board, r - 1, c);
            }
            if (r < board.length - 2 && board[r + 1][c] == 'O') {
                mark(board, r + 1, c);
            }
            if (c > 1 && board[r][c - 1] == 'O') {
                mark(board, r, c - 1);
            }
            if (c < board[0].length - 2 && board[r][c + 1] == 'O') {
                mark(board, r, c + 1);
            }
        }
    }
}
