package dynamicProgramming;

/**
 * Created by Yang on 2017/10/7.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Dynamic Programming
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 0) {
                dp[i][0] = i > 0 ? dp[i-1][0] : 1;
            }
            else {
                dp[i][0] = 0;
            }
        }
        for(int j = 0; j < n; j++) {
            if(obstacleGrid[0][j] == 0) {
                dp[0][j] = j > 0 ? dp[0][j-1] : 1;
            }
            else {
                dp[0][j] = 0;
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
