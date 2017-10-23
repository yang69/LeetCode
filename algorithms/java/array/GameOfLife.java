package array;

/**
 * Created by Yang on 2017/10/23.
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        // https://discuss.leetcode.com/topic/29054/easiest-java-solution-with-explanation
        // 用最后一个比特存储目前的状态，倒数第二个比特存储下一刻的状态
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lifes = getNumOfLiveNeighbors(board, i, j);
                if (board[i][j] == 1 && lifes >= 2 && lifes <= 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && lifes == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int getNumOfLiveNeighbors(int[][] board, int r, int c) {
        int count = 0;
        for (int i = Math.max(0, r-1); i < Math.min(board.length, r+2); i++) {
            for (int j = Math.max(0, c-1); j < Math.min(board[0].length, c+2); j++) {
                if ((board[i][j] & 1) != 0) {
                    count++;
                }
            }
        }
        count -= (board[r][c] & 1);

        return count;
    }
}
