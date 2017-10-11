package dynamicProgramming;

/**
 * Created by Yang on 2017/10/11.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1]; //以matrix[i][j]为右下角的最大的正方形的边长（因为可以原地更新dp每行的值，所以只需要一维）
        int maxSquareLength = 0; //最大的正方形的边长
        for (int i = 1; i <= rows; i++) {
            int prev = 0; // prev用于在每轮迭代中保存dp[j-1]的值
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(prev, dp[j - 1]), dp[j]) + 1;
                    if (dp[j] > maxSquareLength) {
                        maxSquareLength = dp[j];
                    }
                } else { //matrix[i-1][j-1] == '0'的情况
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxSquareLength * maxSquareLength;
    }
}
